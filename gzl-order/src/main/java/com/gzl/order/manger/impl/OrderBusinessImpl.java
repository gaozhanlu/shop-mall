package com.gzl.order.manger.impl;

import com.gzl.common.model.order.product.PurchaseProductRequest;
import com.gzl.common.model.order.purchase.PurchaseRequest;
import com.gzl.common.model.shop.product.ProductRequest;
import com.gzl.common.model.shop.product.ProductStorageDetailRequest;
import com.gzl.common.model.shop.product.ProductStorageDetailResponse;
import com.gzl.common.result.ViewResult;
import com.gzl.order.feign.ShopService;
import com.gzl.order.manger.OrderBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderBusinessImpl implements OrderBusiness {
    @Resource
    private ShopService shopService;


    @Override
    public boolean createOrder(List<PurchaseRequest> purchaseRequestList) {
        for(PurchaseRequest purchaseRequest:purchaseRequestList){
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

        }





        return false;
    }
}
