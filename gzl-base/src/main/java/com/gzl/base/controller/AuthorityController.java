package com.gzl.base.controller;


import com.gzl.base.common.model.base.authority.AuthorityRequest;
import com.gzl.base.common.model.base.authority.AuthorityResponse;
import com.gzl.base.common.result.ViewResult;
import com.gzl.base.entity.Authority;
import com.gzl.base.service.AuthorityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@RestController
@RequestMapping("/authority")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;


    @ApiOperation(value = "添加用户信息")
    @RequestMapping(value = "/saveAuthority", method = RequestMethod.POST)
    public ViewResult saveAuthority(@RequestBody Authority Authority){
        AuthorityResponse AuthorityResponse=authorityService.saveAuthority(Authority);
        return ViewResult.success(AuthorityResponse);
    }

    @ApiOperation(value = "添加用户信息")
    @RequestMapping(value = "/selectAuthority", method = RequestMethod.POST)
    public ViewResult<List<AuthorityResponse>> selectAuthority(@RequestBody AuthorityRequest AuthorityRequest){
        List<AuthorityResponse> AuthorityResponses=authorityService.selectAuthority(AuthorityRequest);
        return ViewResult.success(AuthorityResponses);
    }

}

