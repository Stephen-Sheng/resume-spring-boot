package com.resume.resumespringboot.service.impl;

import com.resume.resumespringboot.mapper.CommentMapper;
import com.resume.resumespringboot.mapper.CommentRelationshipMapper;
import com.resume.resumespringboot.pojo.CommentRelationship;
import com.resume.resumespringboot.service.CommentRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CommentRelationServiceImpl implements CommentRelationService {


    private final CommentRelationshipMapper commentRelationshipMapper;

    @Autowired
    public CommentRelationServiceImpl(@Lazy CommentRelationshipMapper commentRelationshipMapper) {
        this.commentRelationshipMapper = commentRelationshipMapper;
    }

    /**
     * @param commentRelationship
     */
    @Override
    public void insertRelation(CommentRelationship commentRelationship) {
        commentRelationshipMapper.insert(commentRelationship);
    }
}
