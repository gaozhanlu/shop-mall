package com.gzl.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.base.common.model.base.role.RoleRequest;
import com.gzl.base.common.model.base.role.RoleResponse;
import com.gzl.base.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<RoleResponse> selectRole(RoleRequest roleRequest);
}
