package com.gzl.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.common.model.base.authority.AuthorityRequest;
import com.gzl.common.model.base.authority.AuthorityResponse;
import com.gzl.base.entity.Authority;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
public interface AuthorityService extends IService<Authority> {

    AuthorityResponse saveAuthority(Authority authority);

    List<AuthorityResponse> selectAuthority(AuthorityRequest authorityRequest);
}
