package com.gzl.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.common.model.order.product.PurchaseProductRequest;
import com.gzl.common.model.order.product.PurchaseProductResponse;
import com.gzl.order.entity.PurchaseProduct;

import java.util.List;

/**
 * <p>
 * 订单产品表 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
public interface PurchaseProductService extends IService<PurchaseProduct> {

    PurchaseProductResponse savePurchaseProduct(PurchaseProduct purchaseProduct);

    List<PurchaseProductResponse> selectPurchaseProduct(PurchaseProductRequest purchaseProductRequest);
}
