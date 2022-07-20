package com.gzl.base.controller;


import com.gzl.base.entity.Organization;
import com.gzl.base.service.OrganizationService;
import com.gzl.common.model.base.organization.OrganizationRequest;
import com.gzl.common.model.base.organization.OrganizationUserRequest;
import com.gzl.common.model.base.organization.OrganizationUserResponse;
import com.gzl.common.result.ViewResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 组织关系表 可配置 前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    public OrganizationService organizationService;

    @ApiOperation(value = "添加组织结构表")
    @RequestMapping(value = "/insertOrganization", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult insertOrganization(@RequestBody OrganizationRequest organizationRequest){
        organizationService.insertOrganization(organizationRequest);
        return ViewResult.success("");
    }

    @ApiOperation(value = "修改组织结构表")
    @RequestMapping(value = "/updateOrganization", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult updateOrganization(@RequestBody OrganizationRequest organizationRequest){
        organizationService.updateOrganization(organizationRequest);
        return ViewResult.success("");
    }

    @ApiOperation(value = "查询组织结构表")
    @RequestMapping(value = "/selectOrganization", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult selectOrganization(@RequestBody OrganizationRequest organizationRequest){
        List<Organization> Organizations=organizationService.selectOrganization(organizationRequest);
        return ViewResult.success(Organizations);
    }


    @ApiOperation(value = "添加组织结构类型")
    @RequestMapping(value = "/insertOrganizationType", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult insertOrganizationType(@RequestBody OrganizationRequest organizationRequest){
        organizationService.insertOrganization(organizationRequest);
        return ViewResult.success("");
    }


}

