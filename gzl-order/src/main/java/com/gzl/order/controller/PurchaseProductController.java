package com.gzl.order.controller;


import com.gzl.common.model.order.product.PurchaseProductRequest;
import com.gzl.common.model.order.product.PurchaseProductResponse;
import com.gzl.common.result.ViewResult;
import com.gzl.order.entity.PurchaseProduct;
import com.gzl.order.service.PurchaseProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 订单产品表 前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
@RestController
@RequestMapping("/purchase-product")
public class PurchaseProductController {

    @Autowired
    private PurchaseProductService purchaseProductService;


    @ApiOperation(value = "添加购买产品信息")
    @RequestMapping(value = "/savePurchaseProduct", method = RequestMethod.POST)
    public ViewResult savePurchaseProduct(@RequestBody PurchaseProduct purchaseProduct){
        PurchaseProductResponse purchaseProductResponse=purchaseProductService.savePurchaseProduct(purchaseProduct);
        return ViewResult.success(purchaseProductResponse);
    }

    @ApiOperation(value = "搜索购买产品信息")
    @RequestMapping(value = "/selectPurchaseProduct", method = RequestMethod.POST)
    public ViewResult<List<PurchaseProductResponse>> selectPurchaseProduct(@RequestBody PurchaseProductRequest PurchaseProductRequest){
        List<PurchaseProductResponse> PurchaseProductResponses=purchaseProductService.selectPurchaseProduct(PurchaseProductRequest);
        return ViewResult.success(PurchaseProductResponses);
    }

}

