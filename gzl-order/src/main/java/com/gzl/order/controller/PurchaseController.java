package com.gzl.order.controller;


import com.gzl.common.model.order.purchase.PurchaseRequest;
import com.gzl.common.model.order.purchase.PurchaseResponse;
import com.gzl.common.result.ViewResult;
import com.gzl.order.entity.Purchase;
import com.gzl.order.manger.OrderBusiness;
import com.gzl.order.service.PurchaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 采购订单表 前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private OrderBusiness orderBusiness;

    @ApiOperation(value = "添加订单信息")
    @RequestMapping(value = "/savePurchase", method = RequestMethod.POST)
    public ViewResult savePurchase(@RequestBody List<PurchaseRequest> purchaseRequestList){
        orderBusiness.createOrder(purchaseRequestList);
        return ViewResult.success(true);
    }

    @ApiOperation(value = "搜索订单信息")
    @RequestMapping(value = "/selectPurchase", method = RequestMethod.POST)
    public ViewResult<List<PurchaseResponse>> selectPurchase(@RequestBody PurchaseRequest PurchaseRequest){
        List<PurchaseResponse> PurchaseResponses=purchaseService.selectPurchase(PurchaseRequest);
        return ViewResult.success(PurchaseResponses);
    }
    
    
    
}

