package com.resume.resumespringboot.exception;

import com.resume.resumespringboot.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    private JSONResult JSONResult;
    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    @ResponseBody
    public JSONResult returnUserTokenResult(CustomException e){
        return JSONResult.errorTokenMsg(e.getMessage());
    }
}
