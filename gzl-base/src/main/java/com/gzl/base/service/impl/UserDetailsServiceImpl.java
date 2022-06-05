package com.gzl.base.service.impl;

import com.gzl.base.common.domain.LoginUser;
import com.gzl.base.common.model.base.authority.AuthorityResponse;
import com.gzl.base.common.model.base.role.RoleAuthorityResponse;
import com.gzl.base.common.model.base.user.UserRoleAuthorityRequest;
import com.gzl.base.common.model.base.user.UserRoleAuthorityResponse;
import com.gzl.base.common.model.base.user.UserRoleResponse;
import com.gzl.base.common.model.security.UserDetail;
import com.gzl.base.common.util.EntityCopyUtil;
import com.gzl.base.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRoleAuthorityRequest userRoleAuthorityRequest=new UserRoleAuthorityRequest();
        userRoleAuthorityRequest.setUserName(username);
        // 查询用户信息
        List<UserRoleAuthorityResponse> userRoleAuthorityResponseList=userMapper.selectUserRoleAuthority(userRoleAuthorityRequest);
        UserDetail userDetail=new UserDetail();
        UserRoleAuthorityResponse userRoleAuthorityResponse=new UserRoleAuthorityResponse();
        if(userRoleAuthorityResponseList!=null &&userRoleAuthorityResponseList.size()==1){
            userDetail= EntityCopyUtil.toObject(userRoleAuthorityResponseList.get(0),UserDetail.class);
            userRoleAuthorityResponse=userRoleAuthorityResponseList.get(0);
        }else {
            throw new RuntimeException("用户信息有误");
        }
        // 如果没有查询到用户则抛出异常,在过滤链中有异常捕获，这里抛出的异常会被捕获
        if (Objects.isNull(userDetail)) {
            throw new RuntimeException("用户名或密码错误");
        }
        // TODO 查询对应的权限信息
        List<String> authorityList=new ArrayList<>();
        for(RoleAuthorityResponse roleAuthorityResponse:userRoleAuthorityResponse.getRoleAuthorityResponseList()){
            List<String> authority=roleAuthorityResponse.getAuthorityResponseList().stream().map(AuthorityResponse::getAuthorityName).collect(Collectors.toList());
            authorityList.addAll(authority.stream().filter(s -> s==s).collect(Collectors.toList()));
        }
        authorityList.forEach(s -> log.error(s.toString()));
        // 把数据封装成UserDetails返回

        return new LoginUser(userDetail,authorityList);
    }
}