package com.resume.resumespringboot.controller;


import com.resume.resumespringboot.pojo.Job;
import com.resume.resumespringboot.pojo.Resume;
import com.resume.resumespringboot.pojo.bo.JobBo;
import com.resume.resumespringboot.pojo.bo.ResumeBo;
import com.resume.resumespringboot.service.ResumeService;
import com.resume.resumespringboot.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
public class ResumeController {

    private final ResumeService resumeService;
    @Autowired
    public ResumeController(@Lazy ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("insert-resume")
    public JSONResult insertResume(@Valid @RequestBody ResumeBo map, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = UserController.getErrors(bindingResult);
            return JSONResult.errorMap(errorMap);
        }
        String uid = UUID.randomUUID().toString();
        Resume resume = new Resume();
        BeanUtils.copyProperties(map, resume);
        resume.setId(uid);
        JSONResult jsonResult = resumeService.saveResume(resume);
        return jsonResult;
    }

    @GetMapping("get-specific-resume/{resumeId}")
    public JSONResult getSpecificJob(@PathVariable("resumeId") String resumeId){
        JSONResult jsonResult = resumeService.getSpecResume(resumeId);
        return jsonResult;
    }

    @GetMapping("get-resumes/{userId}")
    public JSONResult getSpecificInfo(@PathVariable("userId") String userId){
        JSONResult jsonResult = resumeService.queryResume(userId);
        return jsonResult;
    }

    @PostMapping("editResumeName")
    public JSONResult editResumeName(@RequestBody Map<String,String> map, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = UserController.getErrors(bindingResult);
            return JSONResult.errorMap(errorMap);
        }
        JSONResult jsonResult = resumeService.editName(map.get("id"),map.get("newName"));
        return jsonResult;
    }

    @GetMapping("deleteResume/{resumeId}")
    public JSONResult deleteResume(@PathVariable String resumeId){
        JSONResult jsonResult = resumeService.deleteResume(resumeId);
        return jsonResult;
    }

    @PostMapping("updateResume")
    public JSONResult updateResume(@RequestBody Resume resume,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = UserController.getErrors(bindingResult);
            return JSONResult.errorMap(errorMap);
        }
        JSONResult jsonResult = resumeService.updateResume(resume);
        return jsonResult;
    }

}
