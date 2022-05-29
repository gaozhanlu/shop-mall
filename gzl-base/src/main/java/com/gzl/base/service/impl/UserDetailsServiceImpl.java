package com.gzl.base.service.impl;

import com.gzl.base.common.domain.LoginUser;
import com.gzl.base.common.model.security.UserDetail;
import com.gzl.base.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 查询用户信息

        UserDetail userDetail=new UserDetail();

        // 如果没有查询到用户则抛出异常,在过滤链中有异常捕获，这里抛出的异常会被捕获
        if (Objects.isNull(userDetail)) {
            throw new RuntimeException("用户名或密码错误");
        }
        // TODO 查询对应的权限信息
        List<String> list = new ArrayList<>(Arrays.asList("test", "admin"));
        //TODO 查询对应的权限信息

        // 把数据封装成UserDetails返回

        return new LoginUser(userDetail,list);
    }
}