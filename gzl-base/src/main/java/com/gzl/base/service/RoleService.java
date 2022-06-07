package com.gzl.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.common.model.base.role.RoleAuthorityResponse;
import com.gzl.common.model.base.role.RoleRequest;
import com.gzl.common.model.base.role.RoleResponse;
import com.gzl.common.model.base.user.UserRoleAuthorityRequest;
import com.gzl.base.entity.Role;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
public interface RoleService extends IService<Role> {

    RoleResponse saveRole(Role role);

    List<RoleResponse> selectRole(RoleRequest roleRequest);

    List<RoleAuthorityResponse>  selectRoleAuthorityMap(UserRoleAuthorityRequest userRoleAuthorityRequest);
}
