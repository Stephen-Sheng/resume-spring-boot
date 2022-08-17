package com.resume.resumespringboot.mapper;

import com.resume.resumespringboot.myMapper.MyMapper;
import com.resume.resumespringboot.pojo.Jobitem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

public interface JobItemCustomMapper {

    @Select("SELECT jobitem.*,job.website,job.logo,job.description,job.category,job.employee FROM jobitem INNER JOIN job ON jobitem.companyId = job.id WHERE jobitem.id=#{itemId}")
    public Map<String,String> queryJobItemById(@Param("itemId") String itemId);
}