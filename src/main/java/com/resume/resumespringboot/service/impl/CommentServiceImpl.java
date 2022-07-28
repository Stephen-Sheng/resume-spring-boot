package com.resume.resumespringboot.service.impl;

import com.resume.resumespringboot.mapper.CommentMapper;
import com.resume.resumespringboot.pojo.Comment;
import com.resume.resumespringboot.service.CommentService;
import com.resume.resumespringboot.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(@Lazy CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    /**
     * @param comment
     * @return
     */
    @Override
    public JSONResult saveComment(Comment comment) {
        commentMapper.insert(comment);
        return JSONResult.ok();
    }

    /**
     * @param commentId
     * @return
     */
    @Override
    public JSONResult deleteComment(String commentId) {
        commentMapper.deleteByPrimaryKey(commentId);
        return JSONResult.ok();
    }

    /**
     * @param postId
     * @return
     */
    @Override
    public JSONResult queryCommentByPostId(String postId) {
        Example example = new Example(Comment.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("postId",postId);
        List<Comment> comments = commentMapper.selectByExample(example);
        return JSONResult.ok(comments);
    }
}
