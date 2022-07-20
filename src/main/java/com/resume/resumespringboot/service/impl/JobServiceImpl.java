package com.resume.resumespringboot.service.impl;


import com.resume.resumespringboot.mapper.JobMapper;
import com.resume.resumespringboot.pojo.Job;
import com.resume.resumespringboot.service.JobService;
import com.resume.resumespringboot.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class JobServiceImpl implements JobService {

    private final JobMapper jobMapper;

    @Autowired
    public JobServiceImpl(@Lazy JobMapper jobMapper) {
        this.jobMapper = jobMapper;
    }

    @Override
    public JSONResult saveJob(Job job){
        jobMapper.insert(job);
        return JSONResult.ok();
    }

    @Override
    public JSONResult getJobLst(){
        Optional<List<Job>> result = Optional.ofNullable(jobMapper.selectAll());
        if (result.isPresent()){

            return JSONResult.ok(result);
        }
        return JSONResult.errorMsg("null");

    }

    @Override
    public JSONResult getSpecJob(String jobId){
        Job job = new Job();
        job.setId(jobId);
        Optional<Job> result = Optional.ofNullable(jobMapper.selectOne(job));
        if(result.isPresent()){
            return JSONResult.ok(result);
        }else{
           return JSONResult.errorMsg("Invalid Job ID");
        }
    }
}
