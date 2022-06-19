package com.gzl.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.common.model.order.purchase.PurchaseRequest;
import com.gzl.common.model.order.purchase.PurchaseResponse;
import com.gzl.order.entity.Purchase;

import java.util.List;

/**
 * <p>
 * 采购订单表 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
public interface PurchaseService extends IService<Purchase> {

    PurchaseResponse savePurchase(Purchase purchase);

    List<PurchaseResponse> selectPurchase(PurchaseRequest purchaseRequest);
}
