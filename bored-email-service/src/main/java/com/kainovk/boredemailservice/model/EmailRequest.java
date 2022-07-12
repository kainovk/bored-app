package com.kainovk.boredemailservice.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EmailRequest {
    String to;
    String subject;
    String text;
}
