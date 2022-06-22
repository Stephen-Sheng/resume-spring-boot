package com.resume.resumespringboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    @ResponseBody
    public Map<String, Object> returnUserTokenResult(CustomException e){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", e.getMessage());
        return map;
    }
}
