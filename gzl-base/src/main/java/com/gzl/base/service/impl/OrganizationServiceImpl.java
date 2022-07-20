package com.gzl.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.base.entity.Organization;
import com.gzl.base.mapper.OrganizationMapper;
import com.gzl.base.service.OrganizationService;
import com.gzl.common.model.base.organization.OrganizationRequest;
import com.gzl.common.util.entityUtil.EntityCopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 组织关系表 可配置 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements OrganizationService {

    @Resource
    private OrganizationMapper organizationMapper;

    @Override
    public void insertOrganization(OrganizationRequest organizationRequest) {
        Organization organization= EntityCopyUtil.toObject(organizationRequest,Organization.class);
        organizationMapper.insert(organization);
    }

    @Override
    public void updateOrganization(OrganizationRequest organizationRequest) {
        organizationMapper.updateOrganization(organizationRequest);
    }

    @Override
    public List<Organization> selectOrganization(OrganizationRequest organizationRequest) {
        return organizationMapper.selectOrganization(organizationRequest);
    }
}
