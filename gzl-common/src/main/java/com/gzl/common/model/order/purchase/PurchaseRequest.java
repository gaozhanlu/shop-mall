package com.gzl.common.model.order.purchase;

import com.gzl.common.model.order.product.PurchaseProductRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PurchaseRequest {
    private Integer id;

    @ApiModelProperty(value = "订单类型")
    private String orderType;

    @ApiModelProperty(value = "订单号")
    private String orderSn;

    @ApiModelProperty(value = "订单人id")
    private Integer userId;

    @ApiModelProperty(value = "订单人名字")
    private String userName;

    @ApiModelProperty(value = "供应商id")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商名字")
    private String supplier;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime creatTime;

    @ApiModelProperty(value = "支付方法")
    private String payType;

    @ApiModelProperty(value = "地址")
    private Integer addressId;

    @ApiModelProperty(value = "购买产品的信息")
    private List<PurchaseProductRequest> purchaseProductRequestList;
}
