package com.gzl.order.controller;


import com.gzl.common.model.common.Pattern;
import com.gzl.common.model.order.activity.ActivityRequest;
import com.gzl.common.model.order.product.PurchaseProductRequest;
import com.gzl.common.model.order.product.PurchaseProductResponse;
import com.gzl.common.model.order.purchase.PurchaseRequest;
import com.gzl.common.model.order.purchase.PurchaseResponse;
import com.gzl.common.result.ViewResult;
import com.gzl.order.design.ActivityBuilder;
import com.gzl.order.design.ActivityChain;
import com.gzl.order.entity.Purchase;
import com.gzl.order.manger.DiscountActivity;
import com.gzl.order.manger.OrderBusiness;
import com.gzl.order.manger.impl.CouponActivity;
import com.gzl.order.manger.impl.FullMinusActivity;
import com.gzl.order.manger.impl.MemberActivity;
import com.gzl.order.manger.impl.PromotionActivity;
import com.gzl.order.service.PurchaseService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@Slf4j
//@RefreshScope

//@ConfigurationProperties(prefix="param")
public class PurchaseController {

//    @Value(value = "${work:}")
    @Autowired
    private Pattern pattern;

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
        log.info(pattern.getWork().toString());
        List<PurchaseResponse> PurchaseResponses=purchaseService.selectPurchase(PurchaseRequest);
        return ViewResult.success(PurchaseResponses);
    }





    @ApiOperation(value = "test")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ViewResult test(){
        ActivityRequest activityRequest=null;
        ActivityChain activityChain=new ActivityChain();


        List<String> classNames=new ArrayList<>();
        classNames.add("com.gzl.order.manger.impl.CouponActivity");
        classNames.add("com.gzl.order.manger.impl.MemberActivity");
        classNames.add("com.gzl.order.manger.impl.PromotionActivity");
        classNames.add("com.gzl.order.manger.impl.CouponActivity");


        for (String className:classNames){
            activityChain.addActivity((DiscountActivity)ActivityBuilder.createInstance(className));
        }

//        activityChain
//                .addActivity(new CouponActivity())
//                .addActivity(new FullMinusActivity())
//                .addActivity(new MemberActivity())
//                .addActivity(new PromotionActivity());


        activityChain.doActivity(activityRequest);

        return ViewResult.success(null);
    }
    
    
}

