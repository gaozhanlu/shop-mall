package com.gzl.common.model.order.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PurchaseProductResponse {

    private Integer id;

    @ApiModelProperty(value = "订单号")
    private String orderSn;

    @ApiModelProperty(value = "产品名")
    private String cnName;

    @ApiModelProperty(value = "cas")
    private String cas;

    @ApiModelProperty(value = "品牌名")
    private String brand;

    @ApiModelProperty(value = "货号")
    private String goodsNo;

    @ApiModelProperty(value = "规格")
    private String spec;

    @ApiModelProperty(value = "下单时价格")
    private BigDecimal list;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "监管条件")
    private String supervisionCond;

    @ApiModelProperty(value = "产品pid")
    private String pid;

    @ApiModelProperty(value = "采购数量")
    private Integer num;
}
