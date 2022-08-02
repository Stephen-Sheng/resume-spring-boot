package com.resume.resumespringboot.service;

import com.resume.resumespringboot.pojo.Comment;
import com.resume.resumespringboot.pojo.Jobitem;
import com.resume.resumespringboot.utils.JSONResult;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {


    public JSONResult saveComment(Comment comment);

    public JSONResult deleteComment(String commentId);
    public JSONResult queryCommentByPostId(String postId);

    public JSONResult updateComment(Comment comment);

}
