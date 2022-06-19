package com.gzl.order.feign;

import com.gzl.common.model.shop.product.ProductStorageDetailRequest;
import com.gzl.common.model.shop.product.ProductStorageDetailResponse;
import com.gzl.common.result.ViewResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@FeignClient(value = "gzl-shop")
public interface ShopService {
    @ApiOperation(value = "获取产品库存详情")
    @RequestMapping(value = "/product/selectProductStorageDetail", method = RequestMethod.POST)
    @ResponseBody
    ViewResult<List<ProductStorageDetailResponse>> selectProductStorageDetail(@RequestBody ProductStorageDetailRequest productStorageDetailRequest);

}
