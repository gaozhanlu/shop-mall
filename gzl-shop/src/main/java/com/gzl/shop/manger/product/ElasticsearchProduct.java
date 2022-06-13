package com.gzl.shop.manger.product;


import com.gzl.common.model.shop.product.EsProductRequest;

import java.io.IOException;
import java.util.List;

public interface ElasticsearchProduct {

    boolean saveProductToEs() throws IOException;

}
