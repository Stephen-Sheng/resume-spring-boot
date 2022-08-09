package com.resume.resumespringboot.service;

import com.resume.resumespringboot.pojo.Resume;
import com.resume.resumespringboot.utils.JSONResult;
import org.springframework.stereotype.Service;

@Service
public interface ResumeService {

    public JSONResult saveResume(Resume resume);

    public JSONResult getSpecResume(String resumeId);

//    public JSONResult getSpecInfo(String email);

    public JSONResult queryResume(String userName);

    public JSONResult editName(String id, String newName);

    public JSONResult deleteResume(String id);
    public JSONResult updateResume(Resume resume);

}
