package com.gzl.common.util.elasticsearch;

import java.io.IOException;
import java.util.List;

public interface ElasticsearchMapper {

    List<String> selectIndex(String indexName) throws IOException;
    //创建索引
    boolean createIndex(String indexName) throws IOException;
    //删除索引
    boolean deleteIndex(String indexName) throws IOException;
}
