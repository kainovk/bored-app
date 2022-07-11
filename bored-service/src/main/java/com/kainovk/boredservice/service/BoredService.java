package com.kainovk.boredservice.service;

import com.kainovk.boredservice.model.Activity;

public interface BoredService {
    Activity getRandomActivity();

    Activity getActivityByType(String type);
}
