package com.gzl.uaa.controller;

import com.gzl.common.model.user.UseBaseRequest;
import com.gzl.common.model.user.UseBaseResponse;
import com.gzl.common.result.ViewResult;

import com.gzl.uaa.service.UseBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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


    @Resource
    private UseBaseService useBaseService;

    @ApiOperation(value = "查询用户信息")
    @RequestMapping(value = "/selectUseInfo", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult selectUseInfo(@RequestBody UseBaseRequest useBaseRequest) {
        List<UseBaseResponse> useBaseResponse=useBaseService.selectUseInfo(useBaseRequest);
        return ViewResult.success(useBaseResponse);
    }


}

