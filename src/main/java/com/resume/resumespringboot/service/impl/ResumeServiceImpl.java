package com.resume.resumespringboot.service.impl;


import com.resume.resumespringboot.mapper.ResumeMapper;
import com.resume.resumespringboot.mapper.ResumeCustomMapper;
import com.resume.resumespringboot.pojo.Comment;
import com.resume.resumespringboot.pojo.CommentRelationship;
import com.resume.resumespringboot.pojo.Resume;
import com.resume.resumespringboot.service.ResumeService;
import com.resume.resumespringboot.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class ResumeServiceImpl implements ResumeService {



    @Autowired
    private ResumeMapper resumeMapper;

    @Autowired
    private ResumeCustomMapper resumeCustomMapper;


//    @Autowired
//    public ResumeServiceImpl(@Lazy ResumeMapper resumeMapper) {
//        this.resumeMapper = resumeMapper;
//    }


    @Override
    public JSONResult saveResume(Resume resume) {
        resumeMapper.insert(resume);
        return JSONResult.ok();

    }

    @Override
    public JSONResult getSpecResume(String resumeId) {
        Resume resume = new Resume();
        resume.setId(resumeId);
        Optional<Resume> result = Optional.ofNullable(resumeMapper.selectOne(resume));
        if (result.isPresent()) {
            return JSONResult.ok(result);
        } else {
            return JSONResult.errorMsg("Invalid Resume ID");
        }
    }

    @Override
    public JSONResult queryResume(String userId){

        List<Map<String,String>> list = resumeCustomMapper.queryResumeByUser(userId);
        return JSONResult.ok(list);
    }

    /**
     * @param id
     * @param newName
     * @return
     */
    @Override
    public JSONResult editName(String id, String newName) {
        Example example = new Example(Resume.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",id);
        Resume resume = new Resume();
        resume.setId(id);
        resume.setResumename(newName);
        resumeMapper.updateByPrimaryKeySelective(resume);
        return JSONResult.ok();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public JSONResult deleteResume(String id) {

        resumeMapper.deleteByPrimaryKey(id);
        return JSONResult.ok();
    }

    @Override
    public JSONResult updateResume(Resume resume) {
        resumeMapper.updateByPrimaryKeySelective(resume);
        return JSONResult.ok();
    }


}
