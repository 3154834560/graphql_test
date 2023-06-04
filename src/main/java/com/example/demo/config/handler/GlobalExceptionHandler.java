package com.example.demo.config.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * restful全局异常拦截
 *
 * @author 王景阳
 * @date 2023-03-26 13:11
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleNormalException(Exception e) {
        return e.getMessage();
    }
}
