package com.gzl.common.model.shop.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EsProductRequest {
    @ApiModelProperty(value = "产品标识唯一")
    private String pid;

    @ApiModelProperty(value = "中文名")
    private String cnName;

    @ApiModelProperty(value = "英文名")
    private String enName;

    @ApiModelProperty(value = "cas号")
    private String cas;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "货号")
    private String goodsNo;

    @ApiModelProperty(value = "规格")
    private String spec;

    @ApiModelProperty(value = "供应商sid")
    private String sid;

    @ApiModelProperty(value = "监管条件")
    private String supervisionCond;

    @ApiModelProperty(value = "目录价")
    private BigDecimal listPrice;

    @ApiModelProperty(value = "折扣价")
    private BigDecimal offPrice;

    @ApiModelProperty(value = "促销价")
    private BigDecimal promotionPrice;

    @ApiModelProperty(value = "促销开始时间")
    private LocalDateTime promotionStartTime;

    @ApiModelProperty(value = "促销结束时间")
    private LocalDateTime promotionEndTime;

    @ApiModelProperty(value = "库存数量")
    private Integer stockNum;
}
