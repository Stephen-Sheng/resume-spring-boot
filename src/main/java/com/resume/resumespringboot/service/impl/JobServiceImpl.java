package com.resume.resumespringboot.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public JSONResult getJobLst(Integer page,Integer pageSize){
        Page page1 = PageHelper.startPage(page,pageSize);
        Optional<List<Job>> result = Optional.ofNullable(jobMapper.selectAll());
        Map<String,Object> map = new HashMap<>();
        PageInfo pageInfo = new PageInfo<>(page1);
        map.put("pages",pageInfo.getPages());
        if (result.isPresent()){
            map.put("dataList",result);
            return JSONResult.ok(map);
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
