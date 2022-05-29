package com.gzl.base.entity;

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
 * 权限表
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_authority")
@ApiModel(value="Authority", description="权限表")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "权限名")
    private String authorityName;

    @ApiModelProperty(value = "展示权限名")
    private String showName;

    @ApiModelProperty(value = "权限状态（0显示 1隐藏）")
    private String visible;

    @ApiModelProperty(value = "权限状态（0正常 1停用）")
    private String status;

    @ApiModelProperty(value = "是否删除（0未删除 1已删除）")
    private String delFlag;

    @ApiModelProperty(value = "备注")
    private String remark;

    private Integer createBy;

    private LocalDateTime createTime;

    private Integer updateBy;

    private LocalDateTime updateTime;


}
