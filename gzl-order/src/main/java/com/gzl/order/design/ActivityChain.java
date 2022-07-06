package com.gzl.order.design;

import com.gzl.common.model.order.activity.ActivityRequest;
import com.gzl.order.manger.DiscountActivity;


import java.util.ArrayList;
import java.util.List;

public class ActivityChain {
    private List<DiscountActivity> activities=new ArrayList<DiscountActivity>();


    private static int index=0;

    public ActivityChain addActivity(DiscountActivity discountActivity){
        this.activities.add(discountActivity);
        return this;
    }

    public void doActivity(ActivityRequest activityRequest){
        if(index== activities.size()){
            return;
        }
        DiscountActivity discountActivity=activities.get(index);
        index++;
        discountActivity.countMoney(activityRequest,this);
    }





}
