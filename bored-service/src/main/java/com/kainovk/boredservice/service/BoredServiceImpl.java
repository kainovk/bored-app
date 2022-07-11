package com.kainovk.boredservice.service;

import com.kainovk.boredservice.config.ApiConfig;
import com.kainovk.boredservice.exception.IllegalActivityArgumentException;
import com.kainovk.boredservice.model.Activity;
import com.kainovk.boredservice.model.ActivityType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
@EnableConfigurationProperties(ApiConfig.class)
public class BoredServiceImpl implements BoredService {

    private final ApiConfig apiConfig;
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Activity getRandomActivity() {
        String url = apiConfig.getUrl();
        Activity activity = restTemplate.getForObject(url, Activity.class);
        log.info("Activity: {}", activity);
        return activity;
    }

    @Override
    public Activity getActivityByType(String type) {
        try {
            ActivityType activityType = ActivityType.valueOf(type.toUpperCase());
            String url = apiConfig.getUrl() + "?type=" + activityType.getType();
            Activity activity = restTemplate.getForObject(url, Activity.class);
            log.info("Activity: {}", activity);
            return activity;
        } catch (IllegalArgumentException ex) {
            log.info("Cannot find activity type: {}", type);
            throw new IllegalActivityArgumentException("bad activity type");
        }
    }
}
