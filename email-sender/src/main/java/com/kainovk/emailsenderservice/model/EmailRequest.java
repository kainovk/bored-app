package com.kainovk.emailsenderservice.model;

import lombok.Value;

@Value
public class EmailRequest {
    String to;
    String subject;
    String text;
}
