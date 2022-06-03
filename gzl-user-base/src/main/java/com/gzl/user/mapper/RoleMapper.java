package com.gzl.user.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.gzl.user.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-03-04
 */
@Mapper
@DS("master")
public interface RoleMapper extends BaseMapper<Role> {

}
