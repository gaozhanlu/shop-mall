package com.gzl.user.controller;


//import com.gzl.base.common.model.user.UseBaseRequest;

import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;
import com.gzl.base.common.result.ViewResult;
import com.gzl.user.service.UseBaseService;
//import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-03-02
 */
@RestController
@Api(tags = "use-base",description ="用户基础信息接口")
@RequestMapping("/use-base")
public class UseBaseController {


    @Autowired
    private UseBaseService useBaseService;

    @ApiOperation(value = "查询用户信息")
    @RequestMapping(value = "/selectUseInfo", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult selectUseInfo(@RequestBody UseBaseRequest useBaseRequest) {
        UseBaseResponse useBaseResponse=useBaseService.selectUseInfo(useBaseRequest);
        return ViewResult.success(useBaseResponse);
    }

}

