package com.gzl.shop.mapper;

import com.gzl.base.common.model.product.ProductRequest;
import com.gzl.base.common.model.product.ProductResponse;
import com.gzl.shop.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-03-09
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    @Select({"select * from product limit 100"})
    List<ProductResponse> selectProduct(ProductRequest productRequest);
}
