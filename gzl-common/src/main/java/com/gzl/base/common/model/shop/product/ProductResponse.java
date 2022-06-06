package com.gzl.base.common.model.shop.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductResponse {
    private Integer id;

    @ApiModelProperty(value = "产品标识唯一")
    private String pid;

    @ApiModelProperty(value = "供应商sid")
    private String sid;

    @ApiModelProperty(value = "中文名")
    private String cnName;

    @ApiModelProperty(value = "英文名")
    private String enName;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "cas号")
    private String cas;

    @ApiModelProperty(value = "货号")
    private String goodsNo;

    @ApiModelProperty(value = "规格")
    private String spec;

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

    @ApiModelProperty(value = "库存详情")
    private String stockDetail;

    @ApiModelProperty(value = "运输条件")
    private String transportCond;

    @ApiModelProperty(value = "存储温度")
    private String storageTemperature;

    @ApiModelProperty(value = "预计交货期")
    private String delivery;

    @ApiModelProperty(value = "库存数量")
    private Integer stockNum;

    @ApiModelProperty(value = "危险品等级")
    private String dmgLevel;

    @ApiModelProperty(value = "mdl")
    private String mdl;

    @ApiModelProperty(value = "产品来源   接口  导入  添加方式")
    private String dataSource;

    @ApiModelProperty(value = "第三方编码")
    private String thirdCode;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "更新人")
    private String updateUse;

    @ApiModelProperty(value = "状态 上下架 等等")
    private String stats;
}
