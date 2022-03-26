package com.gzl.gateway.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "secure.ignore")
public class IgnoreUrls {
    private List<String> urls = new ArrayList<>();
}
