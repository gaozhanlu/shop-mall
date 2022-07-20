package com.gzl.base.controller;


import com.gzl.base.entity.Duty;
import com.gzl.base.service.DutyService;
import com.gzl.base.service.OrganizationUserService;
import com.gzl.common.model.base.duty.CheckDutyRequest;
import com.gzl.common.model.base.duty.CheckDutyResponse;
import com.gzl.common.model.base.organization.OrganizationUserRequest;
import com.gzl.common.model.base.organization.OrganizationUserResponse;
import com.gzl.common.result.ViewResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 组织人员表 前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
@RestController
@RequestMapping("/organization-user")
public class OrganizationUserController {
    @Autowired
    public OrganizationUserService organizationUserService;

    @ApiOperation(value = "添加组织结构关系表")
    @RequestMapping(value = "/insertOrganizationUser", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult insertOrganizationUser(@RequestBody OrganizationUserRequest organizationUserRequest){
        organizationUserService.insertOrganizationUser(organizationUserRequest);
        return ViewResult.success("");
    }

    @ApiOperation(value = "修改组织结构关系关系表")
    @RequestMapping(value = "/updateOrganizationUser", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult updateOrganizationUser(@RequestBody OrganizationUserRequest organizationUserRequest){
        organizationUserService.updateOrganizationUser(organizationUserRequest);
        return ViewResult.success("");
    }

    @ApiOperation(value = "查询组织结构关系表")
    @RequestMapping(value = "/selectOrganizationUser", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult<List<OrganizationUserResponse>> selectOrganizationUser(@RequestBody OrganizationUserRequest organizationUserRequest){
        List<OrganizationUserResponse> OrganizationUsers=organizationUserService.selectOrganizationUser(organizationUserRequest);
        return ViewResult.success(OrganizationUsers);
    }

    @ApiOperation(value = "查询组织所有人")
    @RequestMapping(value = "/selectOneOrganizationUser", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult<List<OrganizationUserResponse>> selectOneOrganizationUser(@RequestBody OrganizationUserRequest organizationUserRequest){
        List<OrganizationUserResponse> userList=organizationUserService.selectOneOrganizationUser(organizationUserRequest);
        return ViewResult.success(userList);

    }
}

