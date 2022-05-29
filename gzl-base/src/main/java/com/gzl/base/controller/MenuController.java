package com.gzl.base.controller;


import com.gzl.base.common.model.base.menu.MenuRequest;
import com.gzl.base.common.model.base.menu.MenuResponse;
import com.gzl.base.common.result.ViewResult;
import com.gzl.base.entity.Menu;
import com.gzl.base.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @ApiOperation(value = "添加菜单信息")
    @RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
    public ViewResult saveMenu(@RequestBody Menu Menu){
        MenuResponse MenuResponse=menuService.saveMenu(Menu);
        return ViewResult.success(MenuResponse);
    }

    @ApiOperation(value = "添加菜单信息")
    @RequestMapping(value = "/selectMenu", method = RequestMethod.POST)
    public ViewResult<List<MenuResponse>> selectMenu(@RequestBody MenuRequest MenuRequest){
        List<MenuResponse> MenuResponses=menuService.selectMenu(MenuRequest);
        return ViewResult.success(MenuResponses);
    }

}

