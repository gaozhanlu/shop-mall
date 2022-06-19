package com.gzl.common.model.shop.product;

import lombok.Data;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;

@Data
public class ProductStorageDetailResponse {
    private String pid;
    private String stockDetail;
    private String stockNum;

    private BigDecimal listPrice;
    private BigDecimal offPrice;
    private BigDecimal promotionPrice;

}
