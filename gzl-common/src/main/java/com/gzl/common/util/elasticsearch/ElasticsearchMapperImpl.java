package com.gzl.common.util.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;

import javax.annotation.Resource;

public class ElasticsearchMapperImpl implements ElasticsearchMapper{
    @Resource
    private RestHighLevelClient client;

    private static final String NBA_INDEX = "product_v2";

    private static final int START_OFFSET = 0;

    //返回50个查询到的数据
    private static final  int MAX_COUNT = 1000;

    //被迫 在这里就筛一次...
    private static final int RESULT_COUNT = 50;








}
