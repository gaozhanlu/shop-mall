package com.gzl.base.common.model.base.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserRoleResponse {

//    private Integer userId;
//    private Integer roleId;
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
}
