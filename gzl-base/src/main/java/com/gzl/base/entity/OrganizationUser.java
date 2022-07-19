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
 * 组织人员表
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_organization_user")
@ApiModel(value="OrganizationUser对象", description="组织人员表")
public class OrganizationUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "组织机构id")
    private String organizationId;

    @ApiModelProperty(value = "人员id")
    private Integer userId;

    @ApiModelProperty(value = "职务id")
    private String dutyId;

    @ApiModelProperty(value = "状态")
    private Boolean status;

    @ApiModelProperty(value = "默认启用0.禁用 1启用")
    private Boolean organizationDefault;

    @ApiModelProperty(value = "备注")
    private String remark;

    private Integer createBy;

    private LocalDateTime createTime;

    private Integer updateBy;

    private LocalDateTime updateTime;


}
