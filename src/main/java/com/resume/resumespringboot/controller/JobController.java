package com.resume.resumespringboot.controller;

import com.resume.resumespringboot.pojo.Job;
import com.resume.resumespringboot.pojo.User;
import com.resume.resumespringboot.pojo.bo.JobBo;
import com.resume.resumespringboot.service.JobService;
import com.resume.resumespringboot.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(@Lazy JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("insert-job")
    public JSONResult insertJob(@Valid @RequestBody JobBo map, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = UserController.getErrors(bindingResult);
            return JSONResult.errorMap(errorMap);
        }
        String uid = UUID.randomUUID().toString();
        Job job = new Job();
        BeanUtils.copyProperties(map, job);
        job.setId(uid);
        JSONResult jsonResult = jobService.saveJob(job);

        return jsonResult;
    }

    @GetMapping("get-job")
    public JSONResult getJob(){
        JSONResult jsonResult = jobService.getJobLst();
        return jsonResult;
    }

    @GetMapping("get-specific-job/{jobId}")
    public JSONResult getSpecificJob(@PathVariable("jobId") String jobId){
        JSONResult jsonResult = jobService.getSpecJob(jobId);
        return jsonResult;
    }

}
