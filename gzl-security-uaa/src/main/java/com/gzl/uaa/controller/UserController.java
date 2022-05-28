package com.gzl.uaa.controller;

import com.gzl.base.common.result.ViewResult;
import com.gzl.uaa.entity.User;
import com.gzl.uaa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ViewResult login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/work")
    @PreAuthorize("@AuthInterface.InterfaceAnyAuth('test,admin')")
    public ViewResult work(){
        log.error("测试本接口");
        return ViewResult.success("调用成功");
    }
    @PostMapping("logout")
    public ViewResult logout() {
        return userService.logout();
    }

}
