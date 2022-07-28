package com.resume.resumespringboot.service;

import com.resume.resumespringboot.pojo.Comment;
import com.resume.resumespringboot.pojo.Post;
import com.resume.resumespringboot.utils.JSONResult;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    public JSONResult savePost(Post post);

    public JSONResult deletePost(String postId);
    public JSONResult queryPostById(String postId);
    public JSONResult queryPostListByUserId(String userId);
}
