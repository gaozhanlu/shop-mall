package com.gzl.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.gzl.gateway.model.IgnoreUrls;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Component
@Slf4j
public class gatewayGlobalFilter implements GlobalFilter, Ordered {

    @Resource
    private IgnoreUrls ignoreUrls;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {



        ServerHttpRequest request = exchange.getRequest();
        PathMatcher pathMatcher = new AntPathMatcher();
        for (String path : ignoreUrls.getUrls()) {
            if (pathMatcher.match("/**" + path, request.getPath().toString())) {
                return chain.filter(exchange);
            }
        }

        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null || token.isEmpty()) {
            log.info( "token is empty..." );
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        //合法用户进行下一个过滤链进行过滤验证
        return chain.filter(exchange);


        /*==============================================*/
       /* String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (StrUtil.isEmpty(token)) {
            return chain.filter(exchange);
        }
        try {
            //从token中解析用户信息并设置到Header中去
            String realToken = token.replace("Bearer ", "");

            JWSObject jwsObject = JWSObject.parse(realToken);
            String userStr = jwsObject.getPayload().toString();
            log.info("AuthGlobalFilter.filter() user:{}",userStr);
            ServerHttpRequest request = exchange.getRequest().mutate().header("user", userStr).build();
            exchange = exchange.mutate().request(request).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chain.filter(exchange);*/

    }

    //这个0数字代表加载过滤器的顺序，就是越小优先级越高，因为是全局的，所以必须是第一位的。
    @Override
    public int getOrder() {
        return 0;
    }
}
