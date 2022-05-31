package com.gzl.base.common.packagemodel;

import com.gzl.base.common.model.base.user.UserRoleAuthorityResponse;
import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private Long num;
    private T data;

}
