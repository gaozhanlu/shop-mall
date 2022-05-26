package com.gzl.uaa.service;

import cn.hutool.crypto.digest.BCrypt;
import com.alibaba.fastjson.JSON;

import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;
import com.gzl.uaa.dao.UserDao;
import com.gzl.uaa.entity.UseBase;
import com.gzl.uaa.mapper.UseBaseMapper;
import com.gzl.uaa.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
@Slf4j
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //根据 账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        String str=passwordEncoder.encode("secret");
        log.error(str.toString());


        String str2= BCrypt.hashpw("secret",BCrypt.gensalt());
        log.error(str2.toString());

        //将来连接数据库根据账号查询用户信息
        UserDto userDto = userDao.getUserByUsername(username);
        if(userDto == null){
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }
        //根据用户的id查询用户的权限
        List<String> permissions = userDao.findPermissionsByUserId(userDto.getId());
        //将permissions转成数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        //将userDto转成json
        String principal = JSON.toJSONString(userDto);
        UserDetails userDetails = User.withUsername(principal).password(userDto.getPassword()).authorities(permissionArray).build();
        return userDetails;
//        UseBaseRequest useBaseRequest=new UseBaseRequest();
//        useBaseRequest.setAccountName(username);
//        List<UseBaseResponse> useBaseResponses = useBaseMapper.selectUseInfo(useBaseRequest);
//        //将来连接数据库根据账号查询用户信息
//        UserDto userDto =new UserDto();
//
//        for(UseBaseResponse useBaseResponse:useBaseResponses){
//            userDto.setUsername(useBaseResponse.getAccountName());
//            userDto.setPassword(useBaseResponse.getPassWord());
//            userDto.setFullname(useBaseResponse.getAccountName());
//        }
//        //根据用户的id查询用户的权限
//        List<String> permissions = useBaseResponses.stream().map(UseBaseResponse::getRoleName).collect(Collectors.toList());
//        //将permissions转成数组
//        String[] permissionArray = new String[permissions.size()];
//        permissions.toArray(permissionArray);
//        //将userDto转成json
//        String principal = JSON.toJSONString(userDto);
//        UserDetails userDetails = User.withUsername(principal).password(userDto.getPassword()).authorities(permissionArray).build();
//        return userDetails;
    }
}
