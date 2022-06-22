package com.resume.resumespringboot.exception;

import java.util.Map;

public class ExceptionThrown  {

    public static void display(String errMsg){
        throw new CustomException(errMsg);
    }
}
