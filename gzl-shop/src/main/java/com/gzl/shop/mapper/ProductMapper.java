package com.gzl.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzl.common.model.shop.product.EsProductResponse;
import com.gzl.common.model.shop.product.ProductRequest;
import com.gzl.common.model.shop.product.ProductResponse;
import com.gzl.common.util.mybatisPlus.RootMapper;
import com.gzl.shop.entity.Product;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-06-06
 */
@Mapper
public interface ProductMapper extends RootMapper<Product> {

    List<ProductResponse> selectProduct(ProductRequest productRequest);

    void  insertOrUpdateProduct(ProductRequest productRequest);

    void  batchInsertOrUpdateProduct(List<ProductRequest> productRequestList);

    List<EsProductResponse> selectEsProduct(Page<EsProductResponse> pagination);

    int batchUpdateProduct(List<ProductRequest> productRequestList);

    int batchReplaceProduct(List<ProductRequest> productRequestList);

    void createTemporaryTable(String tableName);

    void deleteTemporaryTable(String tableName);

    int batchInsertProductTemporaryTable(List<ProductRequest> productRequestList);


    int batchUpdateProductByTemporaryTable();
}
