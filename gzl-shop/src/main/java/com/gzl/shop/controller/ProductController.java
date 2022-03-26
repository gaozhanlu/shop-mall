package com.gzl.shop.controller;


import com.gzl.base.common.model.product.ProductRequest;
import com.gzl.base.common.model.product.ProductResponse;
import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;
import com.gzl.base.common.result.ViewResult;
import com.gzl.shop.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gzl
 * @since 2022-03-09
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "查找产品信息")
    @RequestMapping(value = "/selectProduct", method = RequestMethod.POST)
    @ResponseBody
    public ViewResult selectProduct(@RequestBody ProductRequest productRequest) {
        List<ProductResponse> productResponseList= productService.selectProduct(productRequest);
        return ViewResult.success(productResponseList);
    }

}

