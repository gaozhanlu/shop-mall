package com.gzl.order.manger;

import com.gzl.common.model.order.purchase.PurchaseRequest;
import com.gzl.common.model.shop.product.ProductRequest;

import java.util.List;

public interface OrderBusiness {

    boolean createOrder(List<PurchaseRequest> purchaseRequestList);
}
