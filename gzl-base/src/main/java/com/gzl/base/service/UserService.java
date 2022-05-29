package com.gzl.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.base.common.model.base.user.UserRequest;
import com.gzl.base.common.model.base.user.UserResponse;
import com.gzl.base.common.model.base.user.UserRoleAuthorityResponse;
import com.gzl.base.common.result.ViewResult;
import com.gzl.base.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
public interface UserService extends IService<User> {

    UserResponse saveUser(User user);

    List<UserResponse> selectUser(UserRequest userRequest);

    ViewResult login(User user);

    List<UserRoleAuthorityResponse> selectUserRoleAuthority(UserRequest userRequest);
}
