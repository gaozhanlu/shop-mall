package com.gzl.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.gzl.shop","com.gzl.common"})
@EnableDiscoveryClient
@EnableFeignClients
public class ShopApplication {
    public static void main(String[] ages) {
        SpringApplication.run(ShopApplication.class);
    }
}
