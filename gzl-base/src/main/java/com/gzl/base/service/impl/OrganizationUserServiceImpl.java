package com.gzl.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.base.entity.OrganizationUser;
import com.gzl.base.mapper.OrganizationUserMapper;
import com.gzl.base.service.OrganizationUserService;
import com.gzl.common.model.base.organization.OrganizationUserRequest;
import com.gzl.common.model.base.organization.OrganizationUserResponse;
import com.gzl.common.util.entityUtil.EntityCopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 组织人员表 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
@Service
public class OrganizationUserServiceImpl extends ServiceImpl<OrganizationUserMapper, OrganizationUser> implements OrganizationUserService {

    @Resource
    private OrganizationUserMapper organizationUserMapper;
    @Override
    public void insertOrganizationUser(OrganizationUserRequest organizationUserRequest) {
        OrganizationUser organizationUser= EntityCopyUtil.toObject(organizationUserRequest,OrganizationUser.class);
        organizationUserMapper.insert(organizationUser);
    }

    @Override
    public void updateOrganizationUser(OrganizationUserRequest organizationUserRequest) {
        organizationUserMapper.updateOrganizationUser(organizationUserRequest);
    }

    @Override
    public List<OrganizationUserResponse> selectOrganizationUser(OrganizationUserRequest organizationUserRequest) {
        return organizationUserMapper.selectOrganizationUser(organizationUserRequest);
    }

    @Override
    public List<OrganizationUserResponse> selectOneOrganizationUser(OrganizationUserRequest organizationUserRequest) {
        return organizationUserMapper.selectOrganizationUser(organizationUserRequest);
    }
}
