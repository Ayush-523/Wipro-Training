package com.example.geh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AgeNotFoundException.class)
    public ResponseEntity<String> handleAgeException(
            AgeNotFoundException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(
            Exception ex) {

        return new ResponseEntity<>(
                "Something went wrong : " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}