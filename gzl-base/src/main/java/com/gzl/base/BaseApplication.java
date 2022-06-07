package com.gzl.base;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.gzl.base","com.gzl.common"})
@EnableDiscoveryClient
public class BaseApplication {
    public static void main(String[] ages) {
        SpringApplication.run(BaseApplication.class);
    }
}

