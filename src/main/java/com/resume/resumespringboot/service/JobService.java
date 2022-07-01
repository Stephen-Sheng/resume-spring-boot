package com.resume.resumespringboot.service;


import com.resume.resumespringboot.pojo.Job;
import com.resume.resumespringboot.utils.JSONResult;
import org.springframework.stereotype.Service;

@Service
public interface JobService {

    public JSONResult saveJob(Job job);

    public JSONResult getJobLst();

}
