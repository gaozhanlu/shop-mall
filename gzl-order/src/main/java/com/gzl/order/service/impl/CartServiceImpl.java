package com.gzl.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.common.model.order.cart.CartRequest;
import com.gzl.common.model.order.cart.CartResponse;
import com.gzl.common.util.EntityCopyUtil;
import com.gzl.order.entity.Cart;
import com.gzl.order.mapper.CartMapper;
import com.gzl.order.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Resource
    private CartMapper cartMapper;

    @Override
    public CartResponse saveCart(Cart cart) {
        cartMapper.insert(cart);
        return EntityCopyUtil.toObject(cart,CartResponse.class);
    }

    @Override
    public List<CartResponse> selectCart(CartRequest cartRequest) {
        List<CartResponse> cartResponseList=cartMapper.selectCart(cartRequest);
        return cartResponseList;
    }
}
