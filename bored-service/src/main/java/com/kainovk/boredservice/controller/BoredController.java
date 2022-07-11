package com.kainovk.boredservice.controller;

import com.kainovk.boredservice.model.Activity;
import com.kainovk.boredservice.service.BoredService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
public class BoredController {

    private final BoredService boredService;

    @GetMapping
    public Activity getRandomActivity() {
        return boredService.getRandomActivity();
    }

    @GetMapping("/{type}")
    public Activity getActivityByType(@PathVariable("type") String typeAsString) {
        return boredService.getActivityByType(typeAsString);
    }
}
