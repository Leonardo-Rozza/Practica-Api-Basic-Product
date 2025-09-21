package com.leonardorozza.products.presentation.advice;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GenericErrors {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> genericErrors(MethodArgumentNotValidException e){
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(
                fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        return errors;
    }
}
