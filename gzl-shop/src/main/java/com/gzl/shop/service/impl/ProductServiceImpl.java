package com.gzl.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.base.common.model.shop.product.ProductRequest;
import com.gzl.base.common.model.shop.product.ProductResponse;
import com.gzl.base.common.util.EntityCopyUtil;
import com.gzl.shop.entity.Product;
import com.gzl.shop.mapper.ProductMapper;
import com.gzl.shop.service.ProductService;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-06-06
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public ProductResponse saveProduct(Product product) {
        productMapper.insert(product);
        return EntityCopyUtil.toObject(product,ProductResponse.class);
    }

    @Override
    public List<ProductResponse> selectProduct(ProductRequest productRequest) {
        return productMapper.selectProduct(productRequest);
    }

    @Override
    public void insertOrUpdateProduct(ProductRequest productRequest) {
        productMapper.insertOrUpdateProduct(productRequest);
    }

    @Override
    public void batchInsertOrUpdateProduct(List<ProductRequest> productRequestList) {
        productMapper.batchInsertOrUpdateProduct( productRequestList);
    }
}
