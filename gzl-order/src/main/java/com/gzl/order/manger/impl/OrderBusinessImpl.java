package com.gzl.order.manger.impl;

import com.gzl.common.model.order.product.PurchaseProductRequest;
import com.gzl.common.model.order.purchase.PurchaseRequest;
import com.gzl.common.model.shop.product.ProductRequest;
import com.gzl.common.model.shop.product.ProductStorageDetailRequest;
import com.gzl.common.model.shop.product.ProductStorageDetailResponse;
import com.gzl.common.result.ViewResult;
import com.gzl.common.util.snowflake.Snowflake;
import com.gzl.order.feign.ShopService;
import com.gzl.order.manger.OrderBusiness;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderBusinessImpl implements OrderBusiness {
    @Resource
    private ShopService shopService;
    @Autowired
    private Redisson redisson;



    @Override
    public boolean createOrder(List<PurchaseRequest> purchaseRequestList) {
        for(PurchaseRequest purchaseRequest:purchaseRequestList){
            purchaseRequest.setOrderSn(Snowflake.getNextId());

            List<PurchaseProductRequest> purchaseProductRequestList=purchaseRequest.getPurchaseProductRequestList();
            for (PurchaseProductRequest purchaseProductRequest:purchaseProductRequestList){
                RLock redissonLock=redisson.getLock(purchaseProductRequest.getPid());
                try {
                    // ========= 添加redisson锁并实现锁续命功能 =============
                    /**
                     *  主要执行一下几个操作
                     *
                     *  1、将localKey设置到Redis服务器上，默认过期时间是30s
                     *  2、每10s触发一次锁续命功能
                     */
                    redissonLock.lock();


                    //校验库存
                    ProductStorageDetailRequest productStorageDetailRequest=new ProductStorageDetailRequest();
                    productStorageDetailRequest.setPidList(purchaseRequest.getPurchaseProductRequestList().stream().map(PurchaseProductRequest::getPid).collect(Collectors.toList()));
                    ViewResult viewResult=shopService.selectProductStorageDetail(productStorageDetailRequest);
                    Object object=viewResult.getData();
                    List<ProductStorageDetailResponse> productStorageDetailResponses= (List<ProductStorageDetailResponse>) object;
                    //减库存  或者 锁定库存
                    for (ProductStorageDetailResponse productStorageDetailResponse: productStorageDetailResponses){
                        log.info(productStorageDetailResponse.toString());
                    }
                    //生成订单号

                    //添加到订单表  订单产品表

                    //支付完成

                    //支付失败 恢复库存
                } finally { // 防止异常导致锁无法释放！！！
                    // ============= 释放redisson锁 ==========
                    redissonLock.unlock();
                }
            }


        }





        return false;
    }
}
