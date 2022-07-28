package com.resume.resumespringboot.service.impl;

import com.resume.resumespringboot.mapper.PostMapper;
import com.resume.resumespringboot.pojo.Post;
import com.resume.resumespringboot.service.PostService;
import com.resume.resumespringboot.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(@Lazy PostMapper postMapper) {
        this.postMapper = postMapper;
    }
    /**
     * @param post
     * @return
     */
    @Override
    public JSONResult savePost(Post post) {
        postMapper.insert(post);
        return JSONResult.ok();
    }

    /**
     * @param postId
     * @return
     */
    @Override
    public JSONResult deletePost(String postId) {
        postMapper.deleteByPrimaryKey(postId);
        return JSONResult.ok();
    }

    /**
     * @param postId
     * @return
     */
    @Override
    public JSONResult queryPostById(String postId) {
        Post post = postMapper.selectByPrimaryKey(postId);
        return JSONResult.ok(post);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public JSONResult queryPostListByUserId(String userId) {
        Example example = new Example(Post.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("authorId",userId);
        List<Post> posts = postMapper.selectByExample(example);
        return JSONResult.ok(posts);
    }
}
