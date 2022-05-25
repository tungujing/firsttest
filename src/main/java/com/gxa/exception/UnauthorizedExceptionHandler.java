package com.gxa.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
//@RestControllerAdvice
public class UnauthorizedExceptionHandler {

    @ExceptionHandler({UnauthorizedException.class})
    public String unauthorizedException(){

        System.out.println("00000000000000000000000000000000000000");

        return "unauthorized";
    }
}
