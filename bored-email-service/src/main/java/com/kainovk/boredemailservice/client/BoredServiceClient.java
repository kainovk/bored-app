package com.kainovk.boredemailservice.client;

import com.kainovk.boredemailservice.model.Activity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "bored-service",
        url = "${api.client.url.bored-service}",
        path = "/activities"
)
public interface BoredServiceClient {

    @GetMapping
    Activity getRandomActivity();

    @GetMapping("/{type}")
    Activity getActivityByType(@PathVariable("type") String typeAsString);
}
