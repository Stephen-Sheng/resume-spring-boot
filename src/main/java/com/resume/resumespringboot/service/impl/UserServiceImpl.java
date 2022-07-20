package com.resume.resumespringboot.service.impl;

import com.resume.resumespringboot.mapper.UserMapper;
import com.resume.resumespringboot.pojo.User;
import com.resume.resumespringboot.service.UserService;
import com.resume.resumespringboot.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(@Lazy UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User findUserById(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public JSONResult findUserByCondition(String email, String password) {
//        Example example = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("email",email);
//        criteria.andEqualTo("password",password);
//        User user = userMapper.selectOneByExample(example);
//        user.setPassword(null);
//        模糊查询必须使用ByExample, 大于等于deng
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Optional<User> result = Optional.ofNullable(userMapper.selectOne(user));
        if (result.isPresent()) {
            Map<String,String> map = new HashMap<>();
            map.put("id",result.get().getId());
            map.put("username",result.get().getUsername());
            return JSONResult.ok(map);
        } else {
            return JSONResult.errorMsg("Invalid email or password!");
        }

    }
    @Override
    public boolean findUserByEmail(String email){
        User user = new User();
        user.setEmail(email);
        Optional<User> result = Optional.ofNullable(userMapper.selectOne(user));
        if (result.isPresent()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public JSONResult updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return JSONResult.ok();
    }
}
