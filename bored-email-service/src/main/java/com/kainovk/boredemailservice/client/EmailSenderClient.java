package com.kainovk.boredemailservice.client;

import com.kainovk.boredemailservice.model.EmailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "email-service",
        url = "${api.client.url.email-sender}",
        path = "/mails"
)
public interface EmailSenderClient {

    @PostMapping("/send")
    String sendEmail(@RequestBody EmailRequest emailRequest);
}
