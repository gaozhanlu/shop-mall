package com.gzl.base.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.common.model.base.authority.AuthorityRequest;
import com.gzl.common.model.base.authority.AuthorityResponse;
import com.gzl.base.entity.Authority;


import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@Mapper
public interface AuthorityMapper extends BaseMapper<Authority> {

    List<AuthorityResponse> selectAuthority(AuthorityRequest authorityRequest);
}
