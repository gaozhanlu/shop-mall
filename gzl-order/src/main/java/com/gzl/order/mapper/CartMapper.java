package com.gzl.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.common.model.order.cart.CartRequest;
import com.gzl.common.model.order.cart.CartResponse;
import com.gzl.order.entity.Cart;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * <p>
 * 购物车表 Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
@Mapper
public interface CartMapper extends BaseMapper<Cart> {

    List<CartResponse> selectCart(CartRequest cartRequest);
}
