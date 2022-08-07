package com.resume.resumespringboot.mapper;

import com.resume.resumespringboot.myMapper.MyMapper;
import com.resume.resumespringboot.pojo.Post;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PostCustomMapper{

    @Select("SELECT post.*,user.username FROM post JOIN user ON post.author_id = user.id WHERE post.id=#{postId}")
    public Map<String,String> queryPostUserById(@Param("postId") String postId);

    @Select("SET foreign_key_checks=0")
    public void setKeyCheck();
}