package com.gzl.shop.controller;

import com.gzl.common.result.ViewResult;
import com.gzl.common.util.elasticsearch.ElasticsearchMapper;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/elasticsearch")
public class ElasticsearchController {
    @Autowired
    private ElasticsearchMapper elasticsearchMapper;

    @ApiOperation(value = "添加es存储索引")
    @RequestMapping(value = "/saveIndex", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult saveIndex(@RequestParam String indexName) throws IOException {
        boolean bl=elasticsearchMapper.createIndex(indexName);
        return ViewResult.success(bl);
    }

    @ApiOperation(value = "删除es存储索引")
    @RequestMapping(value = "/deleteIndex", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult deleteIndex(@RequestParam String indexName) throws IOException {
        Boolean bl=elasticsearchMapper.deleteIndex(indexName);
        return ViewResult.success(bl);
    }






}
