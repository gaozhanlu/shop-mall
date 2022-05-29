package com.gzl.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.base.common.model.base.authority.AuthorityRequest;
import com.gzl.base.common.model.base.authority.AuthorityResponse;
import com.gzl.base.common.util.EntityCopyUtil;
import com.gzl.base.entity.Authority;
import com.gzl.base.mapper.AuthorityMapper;
import com.gzl.base.service.AuthorityService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityService {


    @Resource
    private AuthorityMapper authorityMapper;
    @Override
    public AuthorityResponse saveAuthority(Authority authority) {

        authorityMapper.insert(authority);
        return EntityCopyUtil.toObject(authority,AuthorityResponse.class);
    }

    @Override
    public List<AuthorityResponse> selectAuthority(AuthorityRequest authorityRequest) {
        return authorityMapper.selectAuthority(authorityRequest);
    }

}
