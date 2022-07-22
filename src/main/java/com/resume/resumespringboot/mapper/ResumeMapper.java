package com.resume.resumespringboot.mapper;

import com.resume.resumespringboot.pojo.Resume;
import com.resume.resumespringboot.myMapper.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeMapper extends MyMapper<Resume> {
}