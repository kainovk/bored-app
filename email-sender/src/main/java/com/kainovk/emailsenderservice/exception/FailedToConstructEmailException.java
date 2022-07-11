package com.kainovk.emailsenderservice.exception;

public class FailedToConstructEmailException extends RuntimeException {
    public FailedToConstructEmailException(String message) {
        super(message);
    }
}
