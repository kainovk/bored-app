package com.kainovk.boredemailservice.service;

import com.kainovk.boredemailservice.client.BoredServiceClient;
import com.kainovk.boredemailservice.client.EmailSenderClient;
import com.kainovk.boredemailservice.config.ApplicationConfig;
import com.kainovk.boredemailservice.model.Activity;
import com.kainovk.boredemailservice.model.EmailRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
@EnableConfigurationProperties(ApplicationConfig.class)
public class BoredEmailService {

    private final BoredServiceClient boredServiceClient;
    private final EmailSenderClient emailSenderClient;
    private final ApplicationConfig config;

    @Scheduled(cron = "${app.crons.at-nine-am-everyday}")
    public void sendEmailWithActivities() {
        Set<Activity> activities = new HashSet<>();
        while (activities.size() < 5) {
            activities.add(boredServiceClient.getRandomActivity());
        }

        StringBuilder message = new StringBuilder();

        int counter = 0;
        for (Activity activity : activities) {
            counter++;
            message.append(counter).append(". ").append(activity).append("\r\n");
        }

        EmailRequest emailRequest =
                EmailRequest.builder()
                        .to(config.getTo())
                        .subject("Hello! Choose your activities for today :)")
                        .text(message.toString())
                        .build();

        log.info("Sending email");
        emailSenderClient.sendEmail(emailRequest);
    }
}
