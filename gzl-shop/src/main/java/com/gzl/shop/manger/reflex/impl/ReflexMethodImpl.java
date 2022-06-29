package com.gzl.shop.manger.reflex.impl;

import com.gzl.common.model.util.ReflexRequest;
import com.gzl.common.util.DynamicCallMethodUtil;
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
        for (ReflexRequest reflexRequest:reflexRequests){
            dynamicCallMethodUtil.dynamicCallMethod(reflexRequest);
        }

    }
}
