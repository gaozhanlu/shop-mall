package com.gzl.base.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzl.base.entity.User;
import com.gzl.common.model.base.user.UserRequest;
import com.gzl.common.model.base.user.UserResponse;
import com.gzl.common.model.base.user.UserRoleAuthorityRequest;
import com.gzl.common.model.base.user.UserRoleAuthorityResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
@DS("slave")
public interface UserMapper extends BaseMapper<User> {

    List<UserResponse> selectUser(UserRequest userRequest);


    List<UserRoleAuthorityResponse> selectUserRoleAuthority(UserRoleAuthorityRequest userRoleAuthorityRequest);


    IPage<UserRoleAuthorityResponse> selectUserRoleAuthorityPage(Page<UserRoleAuthorityResponse> page, @Param("param")UserRoleAuthorityRequest userRoleAuthorityRequest);






}
