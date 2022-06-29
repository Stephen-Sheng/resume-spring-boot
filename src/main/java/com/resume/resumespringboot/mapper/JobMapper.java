package com.resume.resumespringboot.mapper;

import com.resume.resumespringboot.myMapper.MyMapper;
import com.resume.resumespringboot.pojo.Job;
import org.springframework.stereotype.Repository;


@Repository
public interface JobMapper extends MyMapper<Job> {
}