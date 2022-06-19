package com.gzl.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.common.model.order.purchase.PurchaseRequest;
import com.gzl.common.model.order.purchase.PurchaseResponse;
import com.gzl.common.util.EntityCopyUtil;
import com.gzl.order.entity.Purchase;
import com.gzl.order.mapper.PurchaseMapper;
import com.gzl.order.service.PurchaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 采购订单表 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {

    @Resource
    private PurchaseMapper purchaseMapper;
    @Override
    public PurchaseResponse savePurchase(Purchase purchase) {
        purchaseMapper.insert(purchase);
        return EntityCopyUtil.toObject(purchase,PurchaseResponse.class);
    }

    @Override
    public List<PurchaseResponse> selectPurchase(PurchaseRequest purchaseRequest) {
        List<PurchaseResponse> purchaseResponses=purchaseMapper.selectPurchase(purchaseRequest);
        return purchaseResponses;
    }
}
