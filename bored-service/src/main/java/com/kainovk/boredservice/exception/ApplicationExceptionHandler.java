package com.kainovk.boredservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalActivityArgumentException.class)
    public ResponseEntity<ErrorDto> cannotParseJsonHandle(Exception ex) {
        return new ResponseEntity<>(new ErrorDto(ex.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }
}
