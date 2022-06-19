package com.gzl.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.common.model.order.purchase.PurchaseRequest;
import com.gzl.common.model.order.purchase.PurchaseResponse;
import com.gzl.order.entity.Purchase;

import java.util.List;

/**
 * <p>
 * 采购订单表 Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
public interface PurchaseMapper extends BaseMapper<Purchase> {

    List<PurchaseResponse> selectPurchase(PurchaseRequest purchaseRequest);
}
