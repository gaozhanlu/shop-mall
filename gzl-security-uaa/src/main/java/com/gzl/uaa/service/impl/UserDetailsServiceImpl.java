package com.gzl.uaa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gzl.uaa.domain.LoginUser;
import com.gzl.uaa.entity.User;
import com.gzl.uaa.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 查询用户信息
        User userRequest=new User();
        userRequest.setUserName(username);
        List<User> users= userMapper.selectUser(userRequest);
        User user=new User();
        if(users.size()>0)
           user= users.get(0);

        // 查询用户信息
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(User::getUserName, username);
//        User user = userMapper.selectOne(queryWrapper);

        // 如果没有查询到用户则抛出异常,在过滤链中有异常捕获，这里抛出的异常会被捕获
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或密码错误");
        }

        //TODO 查询对应的权限信息
        // 把数据封装成UserDetails返回
        return new LoginUser(user);
    }
}

