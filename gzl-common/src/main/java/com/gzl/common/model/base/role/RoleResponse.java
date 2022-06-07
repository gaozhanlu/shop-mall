package com.gzl.common.model.base.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoleResponse {
    private Integer id;

    @ApiModelProperty(value = "系统中角色名")
    private String roleName;

    @ApiModelProperty(value = "角色展示名字")
    private String disName;

    @ApiModelProperty(value = "角色状态（0正常 1停用）")
    private String status;

    @ApiModelProperty(value = "删除状态（0正常 1删除）")
    private String delFlag;

    @ApiModelProperty(value = "备注")
    private String remark;

    private Integer createBy;

    private LocalDateTime createTime;

    private Integer updateBy;

    private LocalDateTime updateTime;


}
