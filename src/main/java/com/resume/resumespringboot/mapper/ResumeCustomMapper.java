package com.resume.resumespringboot.mapper;

import com.resume.resumespringboot.pojo.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ResumeCustomMapper {

    @Select("SELECT resume.resumeName, resume.id,resume.userName,resume.phoneNum,resume.email,resume.workLocation,resume.photoUrl,resume.eduInfo,resume.projectInfo,resume.orgInfo,resume.profSkills,resume.otherSkills  FROM user INNER JOIN resume ON user.id=resume.userId WHERE user.id = #{userName}")
    public List<Map<String, String>> queryResumeByUser(@Param("userName") String userName);
}