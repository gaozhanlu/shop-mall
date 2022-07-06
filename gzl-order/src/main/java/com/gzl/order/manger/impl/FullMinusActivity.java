package com.gzl.order.manger.impl;

import com.gzl.common.model.order.activity.ActivityRequest;
import com.gzl.order.design.ActivityChain;
import com.gzl.order.manger.DiscountActivity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FullMinusActivity implements DiscountActivity {
    @Override
    public long countMoney(ActivityRequest activityRequest , ActivityChain activityChain) {
        log.info("满减活动");
        return 0;
    }
}
