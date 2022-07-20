package com.gzl.shop.manger.reflex.impl;

import com.gzl.common.model.util.ReflexRequest;
import com.gzl.common.util.dynamicMethod.DynamicCallMethodUtil;
import com.gzl.shop.manger.reflex.ReflexMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ReflexMethodImpl implements ReflexMethod {
    @Autowired
    private DynamicCallMethodUtil dynamicCallMethodUtil;

    @Override
    public void dynamicMethod(List<ReflexRequest> reflexRequests) {
        ReflexRequest reflex=new ReflexRequest();
        reflex.setMethodName("saveProduct");
        reflex.setClassName("com.gzl.shop.service.ProductService");
        reflexRequests.add(reflex);
        for (ReflexRequest reflexRequest:reflexRequests){
            dynamicCallMethodUtil.dynamicCallMethod(reflexRequest);
        }

    }
}
