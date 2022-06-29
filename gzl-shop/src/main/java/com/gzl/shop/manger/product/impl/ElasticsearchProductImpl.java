package com.gzl.shop.manger.product.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzl.common.model.shop.product.EsProductRequest;
import com.gzl.common.model.shop.product.EsProductResponse;
import com.gzl.common.util.EntityCopyUtil;
import com.gzl.shop.manger.elasticsearch.Elasticsearch;
import com.gzl.shop.manger.product.ElasticsearchProduct;
import com.gzl.shop.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
@Slf4j
@Service
public class ElasticsearchProductImpl implements ElasticsearchProduct {

    @Resource
    private Elasticsearch elasticsearch;

    @Resource
    private ProductMapper productMapper;


    @Override
    public boolean saveProductToEs() throws IOException {
        for (int i = 0; i < 169; i++) {
            Page<EsProductResponse> pagination=new Page<>(i,100000);
            List<EsProductResponse> esProductResponses=productMapper.selectEsProduct(pagination);
            List<EsProductRequest> esProductRequests= EntityCopyUtil.toList(esProductResponses,EsProductRequest.class);
            try{
                elasticsearch.batchInsertProduct(esProductRequests);
            }catch (Exception e){
                log.error("批量添加出现错误");
            }
        }
        return true;
    }
}
