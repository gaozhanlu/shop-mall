package com.gzl.user.component;

import com.gzl.base.common.result.ViewResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;



@Aspect
@Component
@Order(1)
@Slf4j
public class ErrorResultAspect {
    @Pointcut("execution(public * com.gzl.user.controller.*.*(..))")
    public void BindingResult() {
    }

    @Around("BindingResult()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    FieldError fieldError = result.getFieldError();
                    if(fieldError!=null){
                        return ViewResult.validateFailed(fieldError.getDefaultMessage());
                    }else{
                        return ViewResult.validateFailed();
                    }
                }
            }
        }
        return joinPoint.proceed();
    }
}
