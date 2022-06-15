package com.gzl.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.common.model.shop.product.ProductRequest;
import com.gzl.common.model.shop.product.ProductResponse;
import com.gzl.common.util.EntityCopyUtil;
import com.gzl.shop.entity.Product;
import com.gzl.shop.mapper.ProductMapper;
import com.gzl.shop.service.ProductService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<ProductResponse> productResponseList=new ArrayList<>();
        List<ProductResponse> productResponses=productMapper.selectProduct(productRequest);

        //page size num
        Integer num=productResponses.size();
        Integer size=488;
        Integer page=1;
//        if(num>0){
//            int currIdx = (page > 1 ? (page - 1) * size : 0);
//            for (int i = 0; i < size && i < productResponses.size() - currIdx; i++) {
//                ProductResponse data = productResponses.get(currIdx + i);
//                productResponseList.add(data);
//            }
//        }

        productResponseList=productResponses.stream().skip((page-1)*size).limit(size).collect(Collectors.toList());








        return productResponseList;
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
