package com.resume.resumespringboot.service;

import com.resume.resumespringboot.pojo.CommentRelationship;
import org.springframework.stereotype.Service;

@Service
public interface CommentRelationService {


    public void insertRelation(CommentRelationship commentRelationship);
}
