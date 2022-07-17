package com.gzl.base.controller;


import com.gzl.common.error.ApiException;
import com.gzl.common.model.base.user.UserRequest;
import com.gzl.common.model.base.user.UserResponse;
import com.gzl.common.model.base.user.UserRoleAuthorityRequest;
import com.gzl.common.model.base.user.UserRoleAuthorityResponse;
import com.gzl.common.packagemodel.PageRequest;
import com.gzl.common.packagemodel.PageResult;
import com.gzl.common.result.ViewResult;

import com.gzl.base.entity.User;
import com.gzl.base.service.UserService;
import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaType;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.ramostear.captcha.HappyCaptcha.SESSION_KEY;

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
@Slf4j
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

    @ApiOperation(value = "搜索用户信息")
    @RequestMapping(value = "/selectUser", method = RequestMethod.POST)
    @PreAuthorize("@AuthInterface.InterfaceAnyAuth('test,admin')")
    public ViewResult<List<UserResponse>> selectUser(@RequestBody UserRequest userRequest){
        List<UserResponse> userResponses=userService.selectUser(userRequest);
        return ViewResult.success(userResponses);
    }

    @ApiOperation(value = "搜索用户信息")
    @RequestMapping(value = "/selectUserRoleAuthority", method = RequestMethod.POST)
    public ViewResult<List<UserRoleAuthorityResponse>> selectUserRoleAuthority(@RequestBody UserRoleAuthorityRequest userRoleAuthorityRequest){
        List<UserRoleAuthorityResponse> userRoleAuthorityResponses=userService.selectUserRoleAuthority(userRoleAuthorityRequest);
        return ViewResult.success(userRoleAuthorityResponses);
    }

    @ApiOperation(value = "分页查询用户信息")
    @RequestMapping(value = "/selectUserRoleAuthorityPage", method = RequestMethod.POST)
    public ViewResult selectUserRoleAuthorityPage(@RequestBody PageRequest<UserRoleAuthorityRequest> pageRequest){
        PageResult pageResult= userService.selectUserRoleAuthorityPage(pageRequest);
        return ViewResult.success(pageResult);
    }



    @ApiOperation(value = "生成验证码")
    @RequestMapping(value = "/happyCaptcha", method = RequestMethod.POST)
    @ResponseBody
    public void happyCaptcha(HttpServletRequest request, HttpServletResponse response){
        System.out.println("======生成一次验证码======");
        HappyCaptcha.require(request,response)
                .type(CaptchaType.WORD_NUMBER_UPPER)
                .length(4)
                .width(120)
                .height(47)
                .build().finish();
        String captcha = (String)request.getSession().getAttribute(SESSION_KEY);

    }

    @ApiOperation(value = "校验证码")
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    @ResponseBody
    public String verify(String code,HttpServletRequest request){
        //Verification Captcha
        boolean flag = HappyCaptcha.verification(request,code,true);
        if(flag){
            // 校验通过
            HappyCaptcha.remove(request);
        }else {
            HappyCaptcha.remove(request);
            throw new ApiException("验证码错误");
        }
        return code;
    }
}

