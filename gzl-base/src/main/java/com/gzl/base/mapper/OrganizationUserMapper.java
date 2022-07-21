package com.gzl.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.base.entity.OrganizationUser;
import com.gzl.common.model.base.organization.OrganizationUserRequest;
import com.gzl.common.model.base.organization.OrganizationUserResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 组织人员表 Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
@Mapper
public interface OrganizationUserMapper extends BaseMapper<OrganizationUser> {

    void updateOrganizationUser(OrganizationUserRequest organizationUserRequest);

    List<OrganizationUserResponse> selectOrganizationUser(OrganizationUserRequest organizationUserRequest);
}
