package com.gzl.jwt.config;


import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;
import com.gzl.jwt.entity.UseBase;
import com.gzl.jwt.service.UseBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserDetailsServiceImpl
 * @Description TODO
 * @Date 2020/10/14 15:28
 * @Created by zfy
 */
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private PermissionService permissionService;

    @Autowired
    private UseBaseService useBaseService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.getByUsername(username);

        UseBaseRequest useBaseRequest=new UseBaseRequest();
        useBaseRequest.setAccountName(username);

        List<UseBaseResponse> useBaseResponses=useBaseService.selectUseInfo(useBaseRequest);
        UseBaseResponse useBaseResponse=useBaseResponses.get(0);
        if (useBaseResponse == null)
            return null;
//        List<Permission> permissionList = permissionService.queryByUserId(user.getId());
        List<String> permissions = new ArrayList<>();
//        if (permissionList != null && !permissionList.isEmpty())
//            permissionList.stream().forEach(permission -> {
//                permissions.add(permission.getEnname());
//            });
        return new CustomUserDetails(Long.valueOf(useBaseResponse.getId()), username, useBaseResponse.getPassWord(), username, useBaseResponse.getAccountId(), permissions);
    }
}
