package com.gzl.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.common.model.base.role.RoleAuthorityResponse;
import com.gzl.common.model.base.role.RoleRequest;
import com.gzl.common.model.base.role.RoleResponse;
import com.gzl.common.model.base.user.UserRoleAuthorityRequest;
import com.gzl.common.util.entityUtil.EntityCopyUtil;
import com.gzl.base.entity.Role;
import com.gzl.base.mapper.RoleMapper;
import com.gzl.base.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public RoleResponse saveRole(Role role) {
        roleMapper.insert(role);
        return EntityCopyUtil.toObject(role,RoleResponse.class);
    }

    @Override
    public List<RoleResponse> selectRole(RoleRequest roleRequest) {
        return roleMapper.selectRole(roleRequest);
    }


    @Override
    public List<RoleAuthorityResponse> selectRoleAuthorityMap(UserRoleAuthorityRequest userRoleAuthorityRequest) {
        return roleMapper.selectRoleAuthorityMap(userRoleAuthorityRequest);

    }
}
