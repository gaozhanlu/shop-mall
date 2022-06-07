package com.gzl.common.handler;

import com.alibaba.fastjson.JSON;
import com.gzl.common.result.ViewResult;
import com.gzl.common.util.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        /*ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(), "您的权限不足");*/
        ViewResult viewResult=ViewResult.validateFailed("您的权限不足");
        String json = JSON.toJSONString(viewResult);
        // 处理异常，调用工具类
        WebUtils.renderString(response, json);
    }
}

