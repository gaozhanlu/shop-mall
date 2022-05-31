package com.gzl.base.controller;


import com.gzl.base.common.model.base.role.RoleRequest;
import com.gzl.base.common.model.base.role.RoleResponse;
import com.gzl.base.common.result.ViewResult;
import com.gzl.base.entity.Role;
import com.gzl.base.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @ApiOperation(value = "添加角色信息")
    @RequestMapping(value = "/saveRole", method = RequestMethod.POST)
    public ViewResult saveRole(@RequestBody Role Role){
        RoleResponse RoleResponse=roleService.saveRole(Role);
        return ViewResult.success(RoleResponse);
    }

    @ApiOperation(value = "添加角色信息")
    @RequestMapping(value = "/selectRole", method = RequestMethod.POST)
    public ViewResult<List<RoleResponse>> selectRole(@RequestBody RoleRequest RoleRequest){
        List<RoleResponse> RoleResponses=roleService.selectRole(RoleRequest);
        return ViewResult.success(RoleResponses);
    }

}

