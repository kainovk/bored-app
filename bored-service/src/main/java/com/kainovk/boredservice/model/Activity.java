package com.kainovk.boredservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Activity {
    @JsonProperty("activity")
    private String description;
    private ActivityType type;
    private Integer participants;
    private Float price;
    private String link;
    private String key;
    private Float accessibility;
}
