package com.resume.resumespringboot.controller;

import com.resume.resumespringboot.pojo.User;
import com.resume.resumespringboot.pojo.bo.UserBo;
import com.resume.resumespringboot.service.UserService;
import com.resume.resumespringboot.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
public class UserController {

    private final UserService userService;
    public Map<String, String> getErrors(BindingResult result){
        List<FieldError> errorList = result.getFieldErrors();
        Map<String,String> map = new HashMap<>();
        for(FieldError error: errorList){
            String field = error.getField();
            String msg = error.getDefaultMessage();
            map.put(field,msg);
        }
        return map;
    }

    @Autowired
    public UserController(@Lazy UserService userService){
        this.userService = userService;
    }
    @PostMapping("register")
    public String handleRegister(@Valid @RequestBody UserBo map, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String,String> errorMap =getErrors(bindingResult);
            return errorMap.toString();
        }
        String uid = UUID.randomUUID().toString();
        User user = new User();
        BeanUtils.copyProperties(map, user);
        user.setId(uid);
        userService.saveUser(user);
        log.info("Registration Successful");
        return "Registration Successful!";
    }

    @PostMapping("login")
    public User handleLogin(@RequestBody UserBo map){
        User user = userService.findUserByCondition(map.getEmail(), map.getPassword());
        return user;
    }

    @PostMapping("update")
    public String handleUpdate(@RequestBody UserBo map){
        User user = new User();
        BeanUtils.copyProperties(map, user);
        String msg = userService.updateUser(user);
        return msg;
    }
}
