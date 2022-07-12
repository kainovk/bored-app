package com.kainovk.boredemailservice.model;

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

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(
                description +
                ", type: " + type.getType() +
                ", participants: " + participants
        );

        if (price == 0.0) {
            res.append(", price: free");
        } else if (price <= 0.4) {
            res.append(", price: low");
        } else if (price > 0.4 && price <= 0.7) {
            res.append(", price: medium");
        } else if (price > 0.7) {
            res.append(", price: high");
        }

        if (!link.isEmpty()) {
            res.append(", link: ").append(link);
        }

        if (accessibility <= 0.5) {
            res.append(", accessibility: normal");
        } else {
            res.append(", accessibility: low");
        }

        return res.toString();
    }
}
