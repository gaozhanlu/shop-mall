package com.gzl.shop.controller;



import com.gzl.base.common.model.shop.product.ProductRequest;
import com.gzl.base.common.model.shop.product.ProductResponse;
import com.gzl.base.common.result.ViewResult;
import com.gzl.shop.entity.Product;
import com.gzl.shop.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    @ApiOperation(value = "添加或更新产品信息")
    @RequestMapping(value = "/insertOrUpdateProduct", method = RequestMethod.POST)
    public ViewResult insertOrUpdateProduct(@RequestBody ProductRequest productRequest){
        productService.insertOrUpdateProduct(productRequest);
        return ViewResult.success(null);
    }


    @ApiOperation(value = "批量添加或更新产品信息")
    @RequestMapping(value = "/batchInsertOrUpdateProduct", method = RequestMethod.POST)
    public ViewResult batchInsertOrUpdateProduct(@RequestBody List<ProductRequest> productRequestList){
       productService.batchInsertOrUpdateProduct(productRequestList);
        return ViewResult.success(null);
    }
}

