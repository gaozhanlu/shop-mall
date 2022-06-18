package com.gzl.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.order.entity.PurchaseProduct;
import com.gzl.order.mapper.PurchaseProductMapper;
import com.gzl.order.service.PurchaseProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单产品表 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-06-18
 */
@Service
public class PurchaseProductServiceImpl extends ServiceImpl<PurchaseProductMapper, PurchaseProduct> implements PurchaseProductService {

}
