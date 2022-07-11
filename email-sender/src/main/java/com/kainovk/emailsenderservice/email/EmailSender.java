package com.kainovk.emailsenderservice.email;

import com.kainovk.emailsenderservice.model.EmailRequest;

public interface EmailSender {
    void send(EmailRequest emailRequest);
}
