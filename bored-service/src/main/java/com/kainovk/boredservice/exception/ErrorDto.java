package com.kainovk.boredservice.exception;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ErrorDto {
    String error;
}
