package com.gzl.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TokenConfig {


    private String SIGNING_KEY = "gzl6688";

//    @Bean
//    public TokenStore tokenStore() {
//        //JWT令牌存储方案
//        return new JwtTokenStore(accessTokenConverter());
//    }
//
//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey(SIGNING_KEY); //对称秘钥，资源服务器使用该秘钥来验证
//        return converter;
//    }
}
