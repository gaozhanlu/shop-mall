package com.gzl.base.common.util;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class EntityCopyUtil {

    public static<S,T> T toObject(S source, Class<T> targetClass) {
        if (source == null || targetClass == null) {
            return null;
        }
        BeanCopier beanCopier = getBaseCopierByClass((Class<S>) source.getClass(), targetClass);
        T target = getBeanByClass(targetClass);
        beanCopier.copy(source, target, null);
        return target;
    }
    public static<S,T> List<T> toList(List<S> sources, Class<T> targetClass) {
        if (CollectionUtils.isEmpty(sources) || targetClass == null) {
            return Collections.emptyList();
        }
        List<T> result = new ArrayList<>();
        BeanCopier beanCopier = getBaseCopierByClass((Class<S>) sources.get(0).getClass(), targetClass);
        sources.forEach(source -> {
            T target = getBeanByClass(targetClass);
            beanCopier.copy(source, target, null);
            result.add(target);
        });
        return result;
    }

    private static<S,T> BeanCopier getBaseCopierByClass(Class<S> sourceClass, Class<T> targetClass) {
        return BeanCopier.create(sourceClass, targetClass, false);
    }

    private static<T> T getBeanByClass(Class<T> targetClass) {
        try {
            return targetClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("系统内部错误");
        }
    }
}
