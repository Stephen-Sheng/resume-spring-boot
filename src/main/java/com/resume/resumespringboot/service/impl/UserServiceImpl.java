package com.resume.resumespringboot.service.impl;

import com.resume.resumespringboot.mapper.UserMapper;
import com.resume.resumespringboot.pojo.User;
import com.resume.resumespringboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    @Autowired
    public UserServiceImpl(@Lazy UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User findUserById(String id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public User findUserByCondition(String email, String password){
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
        User result= userMapper.selectOne(user);
        log.info(result.toString());
        if(result != null){
            return result;
        }else{
            return null;
        }
    }

    @Override
    public String updateUser(User user){
        userMapper.updateByPrimaryKeySelective(user);
        return "Go!";
    }
}
