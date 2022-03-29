package com.gzl.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserBaseApplication {
    public static void main(String[] ages) {
        SpringApplication.run(UserBaseApplication.class);
    }
}
