package com.resume.resumespringboot.mapper;

import com.resume.resumespringboot.myMapper.MyMapper;
import com.resume.resumespringboot.pojo.Jobitem;
import org.springframework.stereotype.Repository;

@Repository

public interface JobItemMapper extends MyMapper<Jobitem> {
}