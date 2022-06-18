package com.gzl.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单产品表
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("order_purchase_product")
@ApiModel(value="PurchaseProduct对象", description="订单产品表")
public class PurchaseProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
