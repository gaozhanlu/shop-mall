package com.gzl.shop.controller;



import com.gzl.common.model.shop.product.ProductRequest;
import com.gzl.common.model.shop.product.ProductResponse;
import com.gzl.common.model.shop.product.ProductStorageDetailRequest;
import com.gzl.common.model.shop.product.ProductStorageDetailResponse;
import com.gzl.common.result.ViewResult;
import com.gzl.shop.entity.Product;
import com.gzl.shop.manger.product.ElasticsearchProduct;
import com.gzl.shop.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-06-06
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @ApiOperation(value = "添加产品信息")
    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public ViewResult saveProduct(@RequestBody Product product){
        ProductResponse ProductResponse=productService.saveProduct(product);
        return ViewResult.success(ProductResponse);
    }

    @ApiOperation(value = "搜索产品信息")
    @RequestMapping(value = "/selectProduct", method = RequestMethod.POST)
    public ViewResult<List<ProductResponse>> selectProduct(@RequestBody ProductRequest productRequest){
        List<ProductResponse> ProductResponses=productService.selectProduct(productRequest);
        return ViewResult.success(ProductResponses);
    }
    @ApiOperation(value = "获取产品库存信息")
    @RequestMapping(value = "/selectProductStorageDetail", method = RequestMethod.POST)
    public ViewResult<List<ProductStorageDetailResponse>> selectProductStorageDetail(@RequestBody ProductStorageDetailRequest productStorageDetailRequest){
        List<ProductStorageDetailResponse> productStorageDetailResponses=productService.selectProductStorageDetail(productStorageDetailRequest);
        return ViewResult.success(productStorageDetailResponses);
    }



    @ApiOperation(value = "添加或更新产品信息")
    @RequestMapping(value = "/insertOrUpdateProduct", method = RequestMethod.POST)
    public ViewResult insertOrUpdateProduct(@RequestBody ProductRequest productRequest){
        productService.insertOrUpdateProduct(productRequest);
        return ViewResult.success(null);
    }

    @Autowired
    private ElasticsearchProduct elasticsearchProduct;

    @ApiOperation(value = "es添加产品信息")
    @RequestMapping(value = "/saveProductToEs", method = RequestMethod.POST)
    public ViewResult saveProductToEs(@RequestBody ProductRequest productRequest) throws IOException {
        elasticsearchProduct.saveProductToEs();
        return ViewResult.success(null);
    }


    @ApiOperation(value = "批量添加或更新产品信息")
    @RequestMapping(value = "/batchInsertOrUpdateProduct", method = RequestMethod.POST)
    public ViewResult batchInsertOrUpdateProduct(@RequestBody List<ProductRequest> productRequestList){
       productService.batchInsertOrUpdateProduct(productRequestList);
       return ViewResult.success(null);
    }


    @ApiOperation(value = "测试批量添加或更新产品信息")
    @RequestMapping(value = "/insertOrUpdateBatch", method = RequestMethod.POST)
    public ViewResult insertOrUpdateBatch(@RequestBody List<Product> productList){
        productService.insertOrUpdateBatch(productList);
        return ViewResult.success(null);
    }


    @ApiOperation(value = "批量更新产品信息")
    @RequestMapping(value = "/batchUpdateProduct", method = RequestMethod.POST)
    public ViewResult batchUpdateProduct(@RequestBody List<ProductRequest> productRequestList){
        productService.batchInsertProductTemporaryTable(productRequestList);
//        productService.batchUpdateProduct(productRequestList);
        return ViewResult.success(null);
    }

}

