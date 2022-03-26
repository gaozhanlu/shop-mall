package com.gzl.gateway.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@Data
@ConfigurationProperties(prefix = "secure.ignore")
public class IgnoreUrls {
    private List<String> urls = new ArrayList<>();
}
