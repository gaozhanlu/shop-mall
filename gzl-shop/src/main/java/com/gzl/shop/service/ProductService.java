package com.gzl.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.base.common.model.shop.product.ProductRequest;
import com.gzl.base.common.model.shop.product.ProductResponse;
import com.gzl.shop.entity.Product;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gzl
 * @since 2022-06-06
 */
public interface ProductService extends IService<Product> {

    ProductResponse saveProduct(Product product);

    List<ProductResponse> selectProduct(ProductRequest productRequest);
}
