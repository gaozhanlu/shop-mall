package com.gzl.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.shop.entity.Purchase;
import com.gzl.shop.mapper.PurchaseMapper;
import com.gzl.shop.service.PurchaseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 采购订单表 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-06-15
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {

}
