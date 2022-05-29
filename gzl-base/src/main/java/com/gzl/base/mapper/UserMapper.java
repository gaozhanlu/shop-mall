package com.gzl.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.base.common.model.base.user.UserRequest;
import com.gzl.base.common.model.base.user.UserResponse;
import com.gzl.base.common.model.base.user.UserRoleAuthorityResponse;
import com.gzl.base.common.model.base.user.UserRoleResponse;
import com.gzl.base.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<UserResponse> selectUser(UserRequest userRequest);


    List<UserRoleAuthorityResponse> selectUserRoleAuthority(UserRequest userRequest);



}
