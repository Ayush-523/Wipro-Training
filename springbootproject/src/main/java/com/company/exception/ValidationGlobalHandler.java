package com.company.exception;


import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
@Hidden //we can hide the documentation from the controller to the swagger class
@ControllerAdvice
public class ValidationGlobalHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String , String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String,String> errors = new HashMap<String , String>();

        // ex.getBindingResult().getAllErrors().forEach(error -> errors.put(error.getObjectName() , error.getDefaultMessage())

        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField() , error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}