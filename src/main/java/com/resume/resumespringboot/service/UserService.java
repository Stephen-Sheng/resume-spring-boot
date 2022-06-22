package com.resume.resumespringboot.service;

import com.resume.resumespringboot.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public void saveUser(User user);
    public User findUserById(String id);

    public User findUserByCondition(String email, String password);
    public String updateUser(User user);


}
