package com.resume.resumespringboot.controller;

import com.resume.resumespringboot.pojo.Job;
import com.resume.resumespringboot.pojo.Jobitem;
import com.resume.resumespringboot.pojo.bo.JobBo;
import com.resume.resumespringboot.pojo.bo.JobitemBo;
import com.resume.resumespringboot.service.JobItemService;
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
public class JobItemController {

    private final JobItemService jobItemService;

    @Autowired
    public JobItemController(@Lazy JobItemService jobItemService) {
        this.jobItemService = jobItemService;
    }

    @PostMapping("insert-jobitem")
    public JSONResult insertJob(@Valid @RequestBody JobitemBo map, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = UserController.getErrors(bindingResult);
            return JSONResult.errorMap(errorMap);
        }
        String uid = UUID.randomUUID().toString();
        Jobitem jobitem = new Jobitem();
        BeanUtils.copyProperties(map, jobitem);
        jobitem.setId(uid);
        JSONResult jsonResult = jobItemService.saveJobItem(jobitem);

        return jsonResult;
    }

    @GetMapping("search-job/{condition}/{page}")
    public JSONResult getSpecificJob(@PathVariable("condition") String condition, @PathVariable("page") Integer page){
        if (page == null) {
            page = 1;
        }
        int pageSize = 3;
        JSONResult jsonResult = jobItemService.queryJobItemCondition(page,pageSize,condition);
        return jsonResult;
    }

    @GetMapping("get-recomJobList/{page}")
    public JSONResult getRecomJobList(@PathVariable Integer page){
        if (page == null) {
            page = 1;
        }
        int pageSize = 1;
        JSONResult jsonResult = jobItemService.queryRecomJobList(page,pageSize);
        return jsonResult;
    }

    @GetMapping("queryJobItem/{itemId}")
    public JSONResult queryJobItem(@PathVariable("itemId") String itemId){
        JSONResult jsonResult = jobItemService.querySpecJobItemById(itemId);
        return jsonResult;
    }

}
