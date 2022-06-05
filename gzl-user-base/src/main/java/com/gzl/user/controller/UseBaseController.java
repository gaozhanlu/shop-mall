package com.gzl.user.controller;

import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;
import com.gzl.base.common.result.ViewResult;
import com.gzl.base.common.util.EntityCopyUtil;
import com.gzl.user.service.UseBaseService;
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



    @ApiOperation(value = "查询用户信息")
    @RequestMapping(value = "/insertUseInfo", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult insertUseInfo(@RequestBody UseBaseRequest useBaseRequest) {
       useBaseService.insertUseInfo(useBaseRequest);
        return ViewResult.success(null);
    }
    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult login(@RequestBody UseBaseRequest useBaseRequest){
//        UserDetails userDetails= EntityCopyUtil.toObject(useBaseRequest,UserDetails.class);
        return ViewResult.success("");
    }

}

