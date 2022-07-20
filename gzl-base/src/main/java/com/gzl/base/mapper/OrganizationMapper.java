package com.gzl.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.base.entity.Organization;
import com.gzl.common.model.base.organization.OrganizationRequest;

import java.util.List;

/**
 * <p>
 * 组织关系表 可配置 Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
public interface OrganizationMapper extends BaseMapper<Organization> {

    void updateOrganization(OrganizationRequest organizationRequest);

    List<Organization> selectOrganization(OrganizationRequest organizationRequest);
}
