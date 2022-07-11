package com.kainovk.emailsenderservice.controller;

import com.kainovk.emailsenderservice.email.EmailSender;
import com.kainovk.emailsenderservice.model.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail-manager")
@RequiredArgsConstructor
public class MailController {

    private final EmailSender emailSender;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        emailSender.send(emailRequest);
        return "Success!";
    }
}
