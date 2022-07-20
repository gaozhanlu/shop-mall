package com.gzl.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.base.entity.OrganizationUser;
import com.gzl.common.model.base.organization.OrganizationUserRequest;
import com.gzl.common.model.base.organization.OrganizationUserResponse;

import java.util.List;

/**
 * <p>
 * 组织人员表 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
public interface OrganizationUserService extends IService<OrganizationUser> {

    void insertOrganizationUser(OrganizationUserRequest organizationUserRequest);

    void updateOrganizationUser(OrganizationUserRequest organizationUserRequest);

    List<OrganizationUserResponse> selectOrganizationUser(OrganizationUserRequest organizationUserRequest);

    List<OrganizationUserResponse> selectOneOrganizationUser(OrganizationUserRequest organizationUserRequest);
}
