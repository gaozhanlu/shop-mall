package com.gzl.common.model.base.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserRoleAuthorityRequest {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "用户性别（0男，1女，2未知）")
    private String sex;

    @ApiModelProperty(value = "账号状态（0正常 1停用）")
    private String status;

    @ApiModelProperty(value = "删除标志（0代表未删除，1代表已删除）")
    private String delFlag;

    private Integer userId;
    private Integer roleId;
    private Integer authorityId;
}
