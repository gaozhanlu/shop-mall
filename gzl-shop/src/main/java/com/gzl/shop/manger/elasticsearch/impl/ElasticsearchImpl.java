package com.gzl.shop.manger.elasticsearch.impl;

import com.gzl.common.model.shop.product.EsProductRequest;
import com.gzl.shop.manger.elasticsearch.Elasticsearch;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

import static cn.hutool.core.bean.BeanUtil.beanToMap;


@Slf4j
@Service
public class ElasticsearchImpl implements Elasticsearch {

    @Resource
    private RestHighLevelClient client;


    private final static String indexName="product";

    @Override
    public boolean batchInsertProduct(List<EsProductRequest> esProductRequests) throws IOException {
        BulkRequest requests =new BulkRequest();
        Integer i=0;
        for(EsProductRequest esProductRequest : esProductRequests){
            IndexRequest request = new IndexRequest(indexName).id(esProductRequest.getPid()).source(beanToMap(esProductRequest));
            requests.add(request);
            i++;
        }
        log.info("本次添加到es中的数据量"+i.toString());
        BulkResponse response=client.bulk(requests, RequestOptions.DEFAULT);
        return true;
    }
}
