package com.gzl.shop.manger.elasticsearch;

import com.gzl.common.model.shop.product.EsProductRequest;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


public interface Elasticsearch {


    boolean batchInsertProduct(List<EsProductRequest> esProductRequests) throws IOException;
}
