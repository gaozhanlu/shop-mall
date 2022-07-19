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
 * 组织关系表 可配置
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_organization")
@ApiModel(value="Organization对象", description="组织关系表 可配置")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "组织标识")
    private String organizationId;

    @ApiModelProperty(value = "名字")
    private String organizationName;

    @ApiModelProperty(value = "上级的id")
    private String parentId;

    @ApiModelProperty(value = "机构类型  1.部门 2 项目")
    private String organizationType;

    @ApiModelProperty(value = "0.菜单 1，组织")
    private Boolean showType;

    @ApiModelProperty(value = "第三方编码")
    private String thirdCode;

    @ApiModelProperty(value = "启用状态 0，禁用 1 启用")
    private Boolean status;

    @ApiModelProperty(value = "缩些名")
    private String shortName;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "默认启用0.禁用 1启用")
    private Boolean organizationDefault;

    @ApiModelProperty(value = "备注")
    private String remark;

    private Integer createBy;

    private LocalDateTime createTime;

    private Integer updateBy;

    private LocalDateTime updateTime;


}
