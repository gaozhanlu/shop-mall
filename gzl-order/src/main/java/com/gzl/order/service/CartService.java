package com.gzl.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.common.model.order.cart.CartRequest;
import com.gzl.common.model.order.cart.CartResponse;
import com.gzl.order.entity.Cart;

import java.util.List;

/**
 * <p>
 * 购物车表 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
public interface CartService extends IService<Cart> {

    CartResponse saveCart(Cart cart);

    List<CartResponse> selectCart(CartRequest cartRequest);
}
