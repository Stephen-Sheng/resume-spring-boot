package com.resume.resumespringboot.mapper;

import com.resume.resumespringboot.pojo.Resume;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeCustomMapper {

    public List<Resume> queryResumeByName(String userName);
}