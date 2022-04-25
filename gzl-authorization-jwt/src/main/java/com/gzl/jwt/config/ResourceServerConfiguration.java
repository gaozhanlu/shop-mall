package com.gzl.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Classname ResourceServerConfiguration
 * @Description TODO
 * @Date 2020/10/15 11:05
 * @Created by zfy
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    //资源id
    public static final String RESOURCE_ID = "res";

    @Autowired
    private JwtTokenStore jwtTokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore)
                .resourceId(RESOURCE_ID)
                .stateless(false);
    }

   @Override
   public void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()   // CSRF 支持  禁用：csrf().disable()
               .authorizeRequests()    //开启使用HttpServletRequest请求的访问限制
               .antMatchers("/swagger-ui.html").permitAll()
               .antMatchers("/webjars/**").permitAll()
               .antMatchers("/swagger-resources/**").permitAll()
               .antMatchers("/v2/*").permitAll()
               .antMatchers("/csrf").permitAll()
               .antMatchers("/").permitAll()
               .antMatchers("/use-base/login").permitAll()
               .antMatchers("/use-base/insertUseInfo").permitAll()
               .anyRequest().authenticated();
//       http
//               .authorizeRequests()
//               .antMatchers("/use-base/login").permitAll()
//               .anyRequest().authenticated()
//       ;

   }
}
