package com.resume.resumespringboot.service.impl;

import com.resume.resumespringboot.mapper.CommentMapper;
import com.resume.resumespringboot.mapper.CommentRelationshipMapper;
import com.resume.resumespringboot.pojo.CommentRelationship;
import com.resume.resumespringboot.service.CommentRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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

    /**
     * @param parentId
     * @param childId
     */
    @Override
    public void deleteRelation(String parentId, String childId) {

        Example example = new Example(CommentRelationship.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentCommentId",parentId);
        criteria.andEqualTo("childCommentId",childId);
        commentRelationshipMapper.deleteByExample(example);
    }
}
