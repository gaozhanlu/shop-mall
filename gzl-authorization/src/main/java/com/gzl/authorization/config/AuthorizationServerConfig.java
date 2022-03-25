package com.gzl.authorization.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients
                //客户端信息存放在内存
                .inMemory()
                //客户端账号(非用户账号)
                .withClient("clientId")
                //客户端密码（非用户密码）
                .secret(passwordEncoder.encode("123456"))
                //授权模式为授权码模式
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
                //接受或者拒绝后重定向地址
                .redirectUris("http://localhost:8081/login")
                //表示要求的授权范围
                .scopes("all")
                //设置token令牌过期时间
                .accessTokenValiditySeconds(60)
                //设置刷新token令牌过期时间
                .refreshTokenValiditySeconds(48000)
                .autoApprove(true);

    }


}
