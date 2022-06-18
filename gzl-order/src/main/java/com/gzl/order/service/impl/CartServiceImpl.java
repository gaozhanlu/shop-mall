package com.gzl.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.order.entity.Cart;
import com.gzl.order.mapper.CartMapper;
import com.gzl.order.service.CartService;
import org.springframework.stereotype.Service;

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

}
