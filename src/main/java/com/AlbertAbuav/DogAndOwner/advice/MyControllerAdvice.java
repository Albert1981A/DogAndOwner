package com.AlbertAbuav.DogAndOwner.advice;

import com.AlbertAbuav.DogAndOwner.exceptions.SecurityException01;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails errorHandler01(Exception e) {
        return new ErrorDetails("Error Handler 1: ", e.getMessage());
    }

    @ExceptionHandler(SecurityException01.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorDetails errorHandler02(Exception e) {
        return new ErrorDetails("Error Handler 2: ", e.getMessage());
    }
}
