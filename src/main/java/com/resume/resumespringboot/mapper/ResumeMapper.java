package com.resume.resumespringboot.mapper;

import com.resume.resumespringboot.pojo.Resume;
import com.resume.resumespringboot.myMapper.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeMapper extends MyMapper<Resume> {
}