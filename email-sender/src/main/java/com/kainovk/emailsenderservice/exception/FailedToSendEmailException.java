package com.kainovk.emailsenderservice.exception;

public class FailedToSendEmailException extends RuntimeException {
    public FailedToSendEmailException(String message) {
        super(message);
    }
}
