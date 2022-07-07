package com.gzl.order.design;

import com.gzl.order.manger.DiscountActivity;
import com.gzl.order.manger.ObjectBuilder;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ActivityBuilder {

//    private List<Class<?>> activities=new ArrayList<Class<?>>();

    public static Object createInstance(String className){
        try {
            Class clz = Class.forName(className);
            Object obj = clz.newInstance();
            return obj;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }




}
