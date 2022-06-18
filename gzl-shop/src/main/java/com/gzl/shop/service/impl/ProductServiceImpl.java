package com.gzl.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.common.model.shop.product.ProductRequest;
import com.gzl.common.model.shop.product.ProductResponse;
import com.gzl.common.util.EntityCopyUtil;
import com.gzl.common.util.mybatisPlus.RootMapper;
import com.gzl.shop.entity.Product;
import com.gzl.shop.mapper.ProductMapper;
import com.gzl.shop.service.ProductService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Override
    public int insertOrUpdateBatch(List<Product> productList) {
        ProductRequest productRequest=new ProductRequest();
        List<ProductResponse> productResponses= productMapper.selectProduct(productRequest);
        List<Product> products= EntityCopyUtil.toList(productResponses,Product.class);
        return baseMapper.updateBatch(products);
    }

    @Override
    public int batchUpdateProduct(List<ProductRequest> productRequestList) {
        ProductRequest productRequest=new ProductRequest();
        List<ProductResponse> productResponses= productMapper.selectProduct(productRequest);
        List<ProductRequest> productRequests= EntityCopyUtil.toList(productResponses,ProductRequest.class);
        return baseMapper.batchReplaceProduct(productRequests);
    }

    @Override
    @Transactional
    public int batchInsertProductTemporaryTable(List<ProductRequest> productRequestList) {
        ProductRequest productRequest=new ProductRequest();
        List<ProductResponse> productResponses= productMapper.selectProduct(productRequest);
        List<ProductRequest> productRequests= EntityCopyUtil.toList(productResponses,ProductRequest.class);

        productMapper.createTemporaryTable("temporaryTable");
        int num=productMapper.batchInsertProductTemporaryTable(productRequests);

        int numUpdate=productMapper.batchUpdateProductByTemporaryTable();
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return num;
    }


}

