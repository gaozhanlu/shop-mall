package com.gzl.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.common.model.order.product.PurchaseProductRequest;
import com.gzl.common.model.order.product.PurchaseProductResponse;
import com.gzl.common.util.entityUtil.EntityCopyUtil;
import com.gzl.order.entity.PurchaseProduct;
import com.gzl.order.mapper.PurchaseProductMapper;
import com.gzl.order.service.PurchaseProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 订单产品表 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
@Service
public class PurchaseProductServiceImpl extends ServiceImpl<PurchaseProductMapper, PurchaseProduct> implements PurchaseProductService {

    @Resource
    private PurchaseProductMapper purchaseProductMapper;
    @Override
    public PurchaseProductResponse savePurchaseProduct(PurchaseProduct purchaseProduct) {
        purchaseProductMapper.insert(purchaseProduct);
        return EntityCopyUtil.toObject(purchaseProduct,PurchaseProductResponse.class);
    }

    @Override
    public List<PurchaseProductResponse> selectPurchaseProduct(PurchaseProductRequest purchaseProductRequest) {
        List<PurchaseProductResponse> productResponses=purchaseProductMapper.selectPurchaseProduct(purchaseProductRequest);
        return productResponses;
    }
}
