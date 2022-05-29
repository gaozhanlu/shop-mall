package com.gzl.base.common.model.base.authority;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthorityResponse {
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
