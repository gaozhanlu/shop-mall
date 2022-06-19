package com.gzl.order.controller;



import com.gzl.common.model.order.cart.CartRequest;
import com.gzl.common.model.order.cart.CartResponse;
import com.gzl.common.result.ViewResult;
import com.gzl.order.entity.Cart;
import com.gzl.order.service.CartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 购物车表 前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;


    @ApiOperation(value = "添加订单信息")
    @RequestMapping(value = "/saveCart", method = RequestMethod.POST)
    public ViewResult saveCart(@RequestBody Cart cart){
        CartResponse cartResponse=cartService.saveCart(cart);
        return ViewResult.success(cartResponse);
    }

    @ApiOperation(value = "搜索订单信息")
    @RequestMapping(value = "/selectCart", method = RequestMethod.POST)
    public ViewResult<List<CartResponse>> selectCart(@RequestBody CartRequest cartRequest){
        List<CartResponse> cartResponses=cartService.selectCart(cartRequest);
        return ViewResult.success(cartResponses);
    }
}

