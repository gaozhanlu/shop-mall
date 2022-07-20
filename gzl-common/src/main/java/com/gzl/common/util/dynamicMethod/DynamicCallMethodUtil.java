package com.gzl.common.util.dynamicMethod;


import com.gzl.common.model.util.ReflexRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Slf4j
public class DynamicCallMethodUtil {


    public Object dynamicCallMethod(ReflexRequest reflexRequest){
        // 根据给定的类名初始化类
        Class<?> clazz = null;
        try {
            // 根据给定的类名初始化类
            clazz = Class.forName(reflexRequest.getClassName());
            Method[] methods=clazz.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                Method methodString=methods[i];
                log.info(methodString.toString());
                Class<?>[] parameterTypes = methodString.getParameterTypes();
                log.info("参数打印"+parameterTypes);
                Method method = clazz.getMethod(reflexRequest.getMethodName(),parameterTypes);
                Object obj=method.invoke(this,parameterTypes);

            }

            Method method = clazz.getMethod(reflexRequest.getMethodName(),null);
            Object obj=method.invoke(this,null);  //调用
            // 获取参数
            Class<?>[] parameterTypes = method.getParameterTypes();
            // 获取方法的返回值类类型
            Class<?> returnType = method.getReturnType();

        } catch (Exception e) {
            e.printStackTrace();
        }



       return null;



    }






}
