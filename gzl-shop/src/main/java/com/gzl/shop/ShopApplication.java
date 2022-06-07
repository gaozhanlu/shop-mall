package com.gzl.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.gzl.shop","com.gzl.common"})
@EnableDiscoveryClient
public class ShopApplication {
    public static void main(String[] ages) {
        SpringApplication.run(ShopApplication.class);
    }
}
