package com.resume.resumespringboot.service;

import com.resume.resumespringboot.pojo.User;
import com.resume.resumespringboot.utils.JSONResult;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public void saveUser(User user);
    public User findUserById(String id);

    public JSONResult findUserByCondition(String email, String password);
    public JSONResult updateUser(User user);


}
