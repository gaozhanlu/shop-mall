package com.gzl.common.config;

//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchConfig {
    @Value(value = "${elasticsearch.host}")
    private String host;
    @Value(value = "${elasticsearch.port}")
    private Integer port;

//    @Bean
//    public RestHighLevelClient restHighLevelClient() {
//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(new HttpHost(host, port, "http")));
//        //如果是集群
////        RestHighLevelClient client = new RestHighLevelClient(
////                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")
////                        , new HttpHost("127.0.0.1", 9201, "http")
////                        , new HttpHost("127.0.0.1", 9202, "http")));
//        return client;
//    }
}
