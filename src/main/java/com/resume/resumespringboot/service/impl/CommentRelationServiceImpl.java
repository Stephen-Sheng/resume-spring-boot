package com.resume.resumespringboot.service.impl;

import com.resume.resumespringboot.mapper.CommentCustomMapper;
import com.resume.resumespringboot.mapper.CommentMapper;
import com.resume.resumespringboot.mapper.CommentRelationshipMapper;
import com.resume.resumespringboot.pojo.CommentRelationship;
import com.resume.resumespringboot.service.CommentRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class CommentRelationServiceImpl implements CommentRelationService {


    private final CommentRelationshipMapper commentRelationshipMapper;
    private final CommentMapper commentMapper;
    private final CommentCustomMapper commentCustomMapper;

    @Autowired
    public CommentRelationServiceImpl(@Lazy CommentRelationshipMapper commentRelationshipMapper, @Lazy CommentMapper commentMapper,@Lazy CommentCustomMapper commentCustomMapper) {
        this.commentRelationshipMapper = commentRelationshipMapper;
        this.commentMapper = commentMapper;
        this.commentCustomMapper = commentCustomMapper;
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

    /**
     * @param parentId
     */
    @Override
    public void deleteParentRelation(String parentId) {
        commentCustomMapper.setKeyCheck();
        Example example = new Example(CommentRelationship.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentCommentId",parentId);
        List<CommentRelationship> childList = commentRelationshipMapper.selectByExample(example);
        for(CommentRelationship child : childList){
            commentMapper.deleteByPrimaryKey(child.getChildCommentId());
        }
        commentRelationshipMapper.deleteByExample(example);

    }

}
