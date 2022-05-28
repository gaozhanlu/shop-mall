package com.gzl.uaa.handler;

import com.alibaba.fastjson.JSON;
import com.gzl.base.common.result.ViewResult;
import com.gzl.uaa.utils.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
       /* ResponseResult result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "用户认证失败，请重新登录");*/

        ViewResult viewResult=ViewResult.validateFailed("用户认证失败，请重新登录");
        String json = JSON.toJSONString(viewResult);
        // 处理异常，调用工具类
        WebUtils.renderString(response, json);
    }
}
