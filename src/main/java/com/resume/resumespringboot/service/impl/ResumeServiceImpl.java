package com.resume.resumespringboot.service.impl;


import com.resume.resumespringboot.mapper.ResumeMapper;
import com.resume.resumespringboot.mapper.ResumeCustomMapper;
import com.resume.resumespringboot.pojo.Resume;
import com.resume.resumespringboot.service.ResumeService;
import com.resume.resumespringboot.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ResumeServiceImpl implements ResumeService {


    private final ResumeMapper resumeMapper;

    @Autowired
    private ResumeCustomMapper resumeCustomMapper;


    @Autowired
    public ResumeServiceImpl(@Lazy ResumeMapper resumeMapper) {
        this.resumeMapper = resumeMapper;
    }


    @Override
    public JSONResult saveResume(Resume resume) {
        resumeMapper.insert(resume);
        return JSONResult.ok();

    }

    @Override
    public JSONResult getSpecResume(String resumeId) {
        Resume resume = new Resume();
        resume.setId(resumeId);
        Optional<Resume> result = Optional.ofNullable(resumeMapper.selectOne(resume));
        if (result.isPresent()) {
            return JSONResult.ok(result);
        } else {
            return JSONResult.errorMsg("Invalid Resume ID");
        }
    }

    @Override
    public JSONResult queryResume(String userName){

        List<Resume> list = resumeCustomMapper.queryResumeByName(userName);
        return JSONResult.ok(list);
    }

}
