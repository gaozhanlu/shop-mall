package com.gzl.shop.service.impl;

import com.gzl.base.common.model.product.ProductRequest;
import com.gzl.base.common.model.product.ProductResponse;
import com.gzl.shop.entity.Product;
import com.gzl.shop.mapper.ProductMapper;
import com.gzl.shop.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-03-09
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<ProductResponse> selectProduct(ProductRequest productRequest) {
        return productMapper.selectProduct(productRequest);
    }
}
