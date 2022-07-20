package com.gzl.base.controller;


import com.gzl.base.service.DictionaryService;
import com.gzl.common.model.base.dictionary.DictionaryRequest;
import com.gzl.common.model.base.dictionary.DictionaryResponse;
import com.gzl.common.model.base.dictionary.SearchDictionaryRequest;
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
 * @since 2022-07-20
 */
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    @ApiOperation(value = "添加数据字典")
    @RequestMapping(value = "/insertDictionary", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult insertDictionary(@RequestBody List<DictionaryRequest> dictionaryRequests){
        dictionaryService.insertDictionary(dictionaryRequests);
        return ViewResult.success("");
    }

    @ApiOperation(value = "删除数据字典")
    @RequestMapping(value = "/deleteDictionary", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult deleteDictionary(@RequestBody List<DictionaryRequest> dictionaryRequests){
        dictionaryService.deleteDictionary(dictionaryRequests);
        return ViewResult.success("");
    }

    @ApiOperation(value = "更新数据字典")
    @RequestMapping(value = "/updateDictionary", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult updateDictionary(@RequestBody DictionaryRequest dictionaryRequest){
        dictionaryService.updateDictionary(dictionaryRequest);
        return ViewResult.success("");
    }

    @ApiOperation(value = "查找数据字典")
    @RequestMapping(value = "/selectDictionaryCondition", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult<List<DictionaryResponse>> selectDictionaryCondition(@RequestBody SearchDictionaryRequest searchDictionaryRequest){
        List<DictionaryResponse> dictionaryRequestList=dictionaryService.selectDictionaryCondition(searchDictionaryRequest);
        return ViewResult.success(dictionaryRequestList);
    }

}

