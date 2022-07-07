package com.gzl.order.design;

import com.gzl.common.model.order.activity.ActivityRequest;
import com.gzl.order.manger.DiscountActivity;
import org.springframework.lang.Nullable;


import javax.servlet.Filter;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActivityChain {

    private final List<DiscountActivity> activities=new ArrayList<DiscountActivity>();

    @Nullable
    private Iterator<DiscountActivity> iterator;
    @Nullable
    private ActivityRequest activityRequest;

    public ActivityRequest getActivityRequest(){
        return this.activityRequest;
    }


    public ActivityChain addActivity(DiscountActivity discountActivity){
        this.activities.add(discountActivity);
        return this;
    }

    public void doActivity(ActivityRequest activityRequest){
        if (this.iterator == null) {
            this.iterator = this.activities.iterator();
        }

        if (this.iterator.hasNext()) {
            DiscountActivity nextDiscountActivity = this.iterator.next();
            nextDiscountActivity.countMoney(activityRequest,this);
        }
        this.activityRequest=activityRequest;

    }





}
