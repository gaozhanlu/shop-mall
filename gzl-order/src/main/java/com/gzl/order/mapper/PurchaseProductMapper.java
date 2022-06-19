package com.gzl.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.common.model.order.product.PurchaseProductRequest;
import com.gzl.common.model.order.product.PurchaseProductResponse;
import com.gzl.order.entity.PurchaseProduct;

import java.util.List;

/**
 * <p>
 * 订单产品表 Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
public interface PurchaseProductMapper extends BaseMapper<PurchaseProduct> {

    List<PurchaseProductResponse> selectPurchaseProduct(PurchaseProductRequest purchaseProductRequest);
}
