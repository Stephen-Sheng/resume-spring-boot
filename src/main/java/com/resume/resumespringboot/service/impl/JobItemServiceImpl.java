package com.resume.resumespringboot.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.resume.resumespringboot.mapper.JobItemCustomMapper;
import com.resume.resumespringboot.mapper.JobMapper;
import com.resume.resumespringboot.mapper.JobItemMapper;
import com.resume.resumespringboot.pojo.Job;
import com.resume.resumespringboot.pojo.Jobitem;
import com.resume.resumespringboot.service.JobItemService;
import com.resume.resumespringboot.service.JobService;
import com.resume.resumespringboot.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class JobItemServiceImpl implements JobItemService {

    private final JobItemMapper jobItemMapper;

    @Autowired
    public JobItemServiceImpl(@Lazy JobItemMapper jobItemMapper) {
        this.jobItemMapper = jobItemMapper;
    }

    @Autowired
    public JobItemCustomMapper jobItemCustomMapper;

    @Override
    public JSONResult saveJobItem(Jobitem jobItem){
        jobItemMapper.insert(jobItem);
        return JSONResult.ok();
    }

    @Override
    public JSONResult queryJobItemCondition(String itemName){
        Example example = new Example(Jobitem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("itemname","%"+itemName+"%");
        List<Jobitem> jobitem = jobItemMapper.selectByExample(example);
        return JSONResult.ok(jobitem);
    }

    @Override
    public JSONResult queryRecomJobList(Integer page,Integer pageSize){
        Page page1 = PageHelper.startPage(page,pageSize);
        Optional<List<Jobitem>> result = Optional.ofNullable(jobItemMapper.selectAll());
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
    public JSONResult querySpecJobItemById(String itemId){
        Optional<Map<String,String>> result = Optional.ofNullable(jobItemCustomMapper.queryJobItemById(itemId));
        if(result.isPresent()){
            return JSONResult.ok(result);
        }
        return JSONResult.errorMsg("null");
    }



}
