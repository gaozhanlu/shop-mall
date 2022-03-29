package com.gzl.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //认证管理器
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //安全拦截机制（最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()   // CSRF 支持  禁用：csrf().disable()
                .authorizeRequests()    //开启使用HttpServletRequest请求的访问限制
                .antMatchers("/r/r1").hasAnyAuthority("p1")  //必须有p1权限才能访问 /r/r1路径
                .antMatchers("/use-base*").permitAll()
                .anyRequest().permitAll(); //除了/r/**，其它的请求可以访问 ;


//                .anyRequest().authenticated()  //所有请求都要通过认证
//                .and()
//                .formLogin()   //开启表单的身份验证，如果未指定formLogin.loginPage(String)，则将生成默认登录页面
//                .addFilter()   //添加自定义的filter

//                .antMatchers("/resources/**", "/signup", "/about").permitAll() // 指定所有用户进行访问指定的url
//                .antMatchers("/admin/**").hasRole("ADMIN")  //指定具有特定权限的用户才能访问特定目录，hasRole()方法指定用户权限，且不需前缀 “ROLE_“
//                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")//
//                .anyRequest().authenticated()  //任何请求没匹配的都需要进行验证
//                .and()        //login设置  自定义登录页面且允许所有用户登录
//                .formLogin()
//                .loginPage("/login") // 指定自定义登录页面
//                .permitAll(); // 允许所有用户访问登录页面. The formLogin().permitAll() 方法
//     .and
//                .logout()  //logouts 设置
//                .logoutUrl("/my/logout")  // 指定注销路径
//                .logoutSuccessUrl("/my/index") //指定成功注销后跳转到指定的页面
//                .logoutSuccessHandler(logoutSuccessHandler)  //指定成功注销后处理类 如果使用了logoutSuccessHandler()的话， logoutSuccessUrl()就会失效
//                .invalidateHttpSession(true)  // httpSession是否有效时间，如果使用了 SecurityContextLogoutHandler，其将被覆盖
//                .addLogoutHandler(logoutHandler)  //在最后增加默认的注销处理类LogoutHandler
//                .deleteCookies(cookieNamesToClear);//指定注销成功后remove cookies
//        //增加在FilterSecurityInterceptor前添加自定义的myFilterSecurityInterceptor
//        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);

    }
}
