package com.gzl.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.gzl.workflow","com.gzl.common"})
public class WorkFlowApplication {
    public static void main(String[] ages) {
        SpringApplication.run(WorkFlowApplication.class);
    }
}
