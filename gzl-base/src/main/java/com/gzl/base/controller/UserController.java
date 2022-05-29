package com.gzl.base.controller;


import com.gzl.base.common.model.base.user.UserRequest;
import com.gzl.base.common.model.base.user.UserResponse;
import com.gzl.base.common.model.base.user.UserRoleAuthorityResponse;
import com.gzl.base.common.result.ViewResult;

import com.gzl.base.entity.User;
import com.gzl.base.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录接口")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ViewResult login(@RequestBody User user){
        return userService.login(user);
    }

    @ApiOperation(value = "添加用户信息")
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ViewResult saveUser(@RequestBody User user){
        UserResponse userResponse=userService.saveUser(user);
        return ViewResult.success(userResponse);
    }

    @ApiOperation(value = "添加用户信息")
    @RequestMapping(value = "/selectUser", method = RequestMethod.POST)
    public ViewResult<List<UserResponse>> selectUser(@RequestBody UserRequest userRequest){

        List<UserResponse> userResponses=userService.selectUser(userRequest);
        return ViewResult.success(userResponses);
    }
    @ApiOperation(value = "添加用户信息")
    @RequestMapping(value = "/selectUserRoleAuthority", method = RequestMethod.POST)
    public ViewResult<List<UserRoleAuthorityResponse>> selectUserRoleAuthority(@RequestBody UserRequest userRequest){
        List<UserRoleAuthorityResponse> userRoleAuthorityResponses=userService.selectUserRoleAuthority(userRequest);

        return ViewResult.success(userRoleAuthorityResponses);
    }

}

