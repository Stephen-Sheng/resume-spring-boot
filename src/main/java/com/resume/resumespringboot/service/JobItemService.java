package com.resume.resumespringboot.service;


import com.resume.resumespringboot.pojo.Job;
import com.resume.resumespringboot.pojo.Jobitem;
import com.resume.resumespringboot.utils.JSONResult;
import org.springframework.stereotype.Service;

@Service
public interface JobItemService {


    public JSONResult saveJobItem(Jobitem jobitem);

    public JSONResult queryJobItemCondition(String itemName);
    public JSONResult queryRecomJobList(Integer page,Integer pageSize);

    public JSONResult querySpecJobItemById(String itemId);

}
