package com.gzl.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 采购订单表
 * </p>
 *
 * @author gzl
 * @since 2022-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("order_purchase")
@ApiModel(value="Purchase对象", description="采购订单表")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "id", type = IdType.AUTO)
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
    private String supplierName;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime creatTime;

    @ApiModelProperty(value = "支付方法")
    private String payType;

    @ApiModelProperty(value = "地址")
    private Integer addressId;


}
