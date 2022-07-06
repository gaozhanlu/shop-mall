package com.gzl.order.manger;

import com.gzl.common.model.order.activity.ActivityRequest;
import com.gzl.order.design.ActivityChain;

public interface DiscountActivity {

    long countMoney(ActivityRequest activityRequest, ActivityChain activityChain);


}
