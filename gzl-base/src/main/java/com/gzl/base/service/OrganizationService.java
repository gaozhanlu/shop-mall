package com.gzl.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.base.entity.Organization;
import com.gzl.common.model.base.organization.OrganizationRequest;

import java.util.List;

/**
 * <p>
 * 组织关系表 可配置 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
public interface OrganizationService extends IService<Organization> {

    void insertOrganization(OrganizationRequest organizationRequest);

    void updateOrganization(OrganizationRequest organizationRequest);

    List<Organization> selectOrganization(OrganizationRequest organizationRequest);
}
