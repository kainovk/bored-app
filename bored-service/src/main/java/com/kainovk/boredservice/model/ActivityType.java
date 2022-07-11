package com.kainovk.boredservice.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum ActivityType {
    EDUCATION("education"),
    RECREATIONAL("recreational"),
    SOCIAL("social"),
    DIY("diy"),
    CHARITY("charity"),
    COOKING("cooking"),
    RELAXATION("relaxation"),
    MUSIC("music"),
    BUSYWORK("busywork");

    @JsonValue
    private final String type;

    ActivityType(String type) {
        this.type = type;
    }
}
