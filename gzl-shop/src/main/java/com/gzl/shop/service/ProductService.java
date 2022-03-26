package com.gzl.shop.service;

import com.gzl.base.common.model.product.ProductRequest;
import com.gzl.base.common.model.product.ProductResponse;
import com.gzl.shop.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gzl
 * @since 2022-03-09
 */
public interface ProductService extends IService<Product> {

    List<ProductResponse> selectProduct(ProductRequest productRequest);
}
