package com.gzl.authorization.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled;
    @Value(value = "${swagger.ip}")
    String swaggerIp;

    @Value(value = "${server.port}")
    String swaggerPort;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                //在swagger中访问的地址,如果是服务器运行项目需要改成服务器地址加端口号
                .host(swaggerIp+":"+swaggerPort)
                // 是否开启注解
                .enable(swaggerEnabled).select()
                // 扫描的路径包 controller包所在的位置
                .apis(RequestHandlerSelectors.basePackage("com.gzl.authorization.controller"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/");
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("应用接入程序接口")
                // 作者信息
                .version("1.0.0")
                .build();
    }
}
