package com.gzl.base.common.util.notes;


import com.gzl.base.common.logic.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AuthInterface")
public class AuthInterfaceSecurity {

    public boolean InterfaceAnyAuth(String... authorities){
        for (String authority:authorities){
            if(InterfaceAuth(authority)){
                return true;
            }
        }
        return false;
    }


    public boolean InterfaceAuth(String authority) {
        // 获取当前用户的权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();

        // 判断用户权限集合中是否存在authority
        return permissions.contains(authority);
    }

}
