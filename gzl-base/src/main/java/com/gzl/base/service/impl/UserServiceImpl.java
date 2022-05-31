package com.gzl.base.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.base.common.domain.LoginUser;
import com.gzl.base.common.model.base.user.UserRequest;
import com.gzl.base.common.model.base.user.UserResponse;
import com.gzl.base.common.model.base.user.UserRoleAuthorityRequest;
import com.gzl.base.common.model.base.user.UserRoleAuthorityResponse;
import com.gzl.base.common.packagemodel.PageRequest;
import com.gzl.base.common.packagemodel.PageResult;
import com.gzl.base.common.result.ViewResult;
import com.gzl.base.common.util.EntityCopyUtil;
import com.gzl.base.common.util.JwtUtil;
import com.gzl.base.common.util.PageChangeUtil;
import com.gzl.base.common.util.redis.RedisCache;
import com.gzl.base.entity.User;
import com.gzl.base.mapper.UserMapper;
import com.gzl.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;


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


    @Override
    public ViewResult login(User user) {
        // 认证的时候需要Authentication对象，所以需要一个Authentication的实现类，这里选择了UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());

        // AuthenticationManager authenticate方法进行认证。在SecurityConfig配置类中，我们将AuthenticationManager注入到容器中。
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 如果认证通过，authenticate里将包含principal属性，该属性的值就是LoginUser，
        // 如果认证没通过，给出对应的提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }

        // 如果认证通过了，使用userid生成一个jwt jwt存入ResponseResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String id = loginUser.getUserDetail().getId().toString();
        String jwt = JwtUtil.createJWT(id);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);

        // 把完整的用户信息存入redis，userid作为key
        redisCache.setCacheObject("login:" + id, loginUser);

        return ViewResult.success(map);
    }

    @Override
    public List<UserRoleAuthorityResponse> selectUserRoleAuthority(UserRoleAuthorityRequest userRoleAuthorityRequest) {
        return userMapper.selectUserRoleAuthority(userRoleAuthorityRequest);
    }

    @Override
    public PageResult selectUserRoleAuthorityPage(PageRequest<UserRoleAuthorityRequest> pageRequest) {

        Page<UserRoleAuthorityResponse> page=new Page(pageRequest.getPage(), pageRequest.getSize());
        UserRoleAuthorityRequest userRoleAuthorityRequest=pageRequest.getData();
        IPage<UserRoleAuthorityResponse> iPageResult=userMapper.selectUserRoleAuthorityPage(page,userRoleAuthorityRequest);
        return PageChangeUtil.resultChange(iPageResult);
    }




}
