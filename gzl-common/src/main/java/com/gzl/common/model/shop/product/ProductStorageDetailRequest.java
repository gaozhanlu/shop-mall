package com.gzl.common.model.shop.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductStorageDetailRequest {

    private List<String> pidList;
}
