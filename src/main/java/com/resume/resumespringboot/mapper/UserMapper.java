package com.resume.resumespringboot.mapper;

import com.resume.resumespringboot.myMapper.MyMapper;
import com.resume.resumespringboot.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends MyMapper<User> {


}