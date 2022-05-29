package com.gzl.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.gzl.base","com.gzl.base.common.config"})
@EnableDiscoveryClient
public class BaseApplication {
    public static void main(String[] ages) {
        SpringApplication.run(BaseApplication.class);
    }
}

