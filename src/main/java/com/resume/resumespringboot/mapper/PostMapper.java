package com.resume.resumespringboot.mapper;

import com.resume.resumespringboot.myMapper.MyMapper;
import com.resume.resumespringboot.pojo.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMapper extends MyMapper<Post> {
}