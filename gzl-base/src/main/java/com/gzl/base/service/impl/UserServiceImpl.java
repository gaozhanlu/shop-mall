package com.gzl.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.base.common.model.base.user.UserRequest;
import com.gzl.base.common.model.base.user.UserResponse;
import com.gzl.base.common.util.EntityCopyUtil;
import com.gzl.base.entity.User;
import com.gzl.base.mapper.UserMapper;
import com.gzl.base.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Resource
    private UserMapper userMapper;
    @Override
    public UserResponse saveUser(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userMapper.insert(user);
        return EntityCopyUtil.toObject(user,UserResponse.class);
    }

    @Override
    public List<UserResponse> selectUser(UserRequest userRequest) {
        return userMapper.selectUser(userRequest);
    }


}
