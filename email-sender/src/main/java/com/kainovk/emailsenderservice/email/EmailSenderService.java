package com.kainovk.emailsenderservice.email;

import com.kainovk.emailsenderservice.exception.FailedToConstructEmailException;
import com.kainovk.emailsenderservice.exception.FailedToSendEmailException;
import com.kainovk.emailsenderservice.model.EmailRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailSenderService implements EmailSender {

    private final JavaMailSender mailSender;

    @Override
    public void send(EmailRequest email) {
        try {
            log.info("Creating email to {}", email.getTo());
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getText());
            helper.setFrom("${app.email.sender}");
            mailSender.send(mimeMessage);
            log.info("Email sent successfully");
        } catch (MessagingException e) {
            log.error("Failed to construct email");
            throw new FailedToConstructEmailException(e.getMessage());
        } catch (MailException e) {
            log.error("Failed to send email");
            throw new FailedToSendEmailException(e.getMessage());
        }
    }
}
