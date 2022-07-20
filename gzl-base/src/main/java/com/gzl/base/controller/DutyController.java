package com.gzl.base.controller;


import com.gzl.base.entity.Duty;
import com.gzl.base.service.DutyService;
import com.gzl.common.model.base.duty.CheckDutyRequest;
import com.gzl.common.model.base.duty.CheckDutyResponse;
import com.gzl.common.result.ViewResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
@RestController
@RequestMapping("/duty")
public class DutyController {
    @Autowired
    private DutyService dutyService;


    @ApiOperation(value = "添加项目中职务信息")
    @RequestMapping(value = "/insertDuty", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult insertDuty(@RequestBody Duty Duty){
        dutyService.insertDuty(Duty);
        return ViewResult.success("");
    }

    @ApiOperation(value = "修改项目中职务信息")
    @RequestMapping(value = "/updateDuty", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult updateDuty(@RequestBody Duty Duty){
        dutyService.updateDuty(Duty);
        return ViewResult.success("");
    }


    @ApiOperation(value = "查询某个项目中职务信息")
    @RequestMapping(value = "/selectAllDuty", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult<List<CheckDutyResponse>> selectAllDuty(@RequestBody CheckDutyRequest checkDutyRequest){
        List<CheckDutyResponse> checkDutyResponseList=dutyService.selectAllDuty(checkDutyRequest);
        return ViewResult.success(checkDutyResponseList);
    }
}

