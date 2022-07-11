package com.kainovk.boredservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "api")
public class ApiConfig {
    private String url;
}
