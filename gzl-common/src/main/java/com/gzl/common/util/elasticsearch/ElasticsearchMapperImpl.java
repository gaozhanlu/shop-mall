package com.gzl.common.util.elasticsearch;

import lombok.extern.slf4j.Slf4j;


import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class ElasticsearchMapperImpl implements ElasticsearchMapper{
    @Resource
    private RestHighLevelClient client;


    @Override
    public List<String> selectIndex(String indexName) throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
        GetIndexResponse getIndexResponse = client.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        String[] indices = getIndexResponse.getIndices();
        List<String> asList = Arrays.asList(indices);
        return asList;
    }

    //创建索引
    @Override
    public boolean createIndex(String indexName) throws IOException {
        // 1、创建索引请求
        CreateIndexRequest createIndexRequest=new CreateIndexRequest(indexName);
        // 2、客户端执行请求 IndicesClient,请求后获得响应
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        log.info(createIndexResponse.toString());
        return true;
    }
    //删除建索引
    @Override
    public boolean deleteIndex(String indexName) throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(indexName);
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
        return delete.isAcknowledged();
    }
    //查找索引
}
