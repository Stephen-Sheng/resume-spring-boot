package com.resume.resumespringboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@Slf4j
public class CustomException extends RuntimeException{

    public CustomException(String message) {
        super(message);
    }
}
