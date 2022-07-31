package com.resume.resumespringboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.resume.resumespringboot.mapper.PostMapper;
import com.resume.resumespringboot.pojo.Jobitem;
import com.resume.resumespringboot.pojo.Post;
import com.resume.resumespringboot.service.PostService;
import com.resume.resumespringboot.utils.JSONResult;
import javafx.geometry.Pos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
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
    public JSONResult queryPostListByUserId(Integer page, Integer pageSize, String userId) {
        Page page1 = PageHelper.startPage(page,pageSize);
        Map<String,Object> map = new HashMap<>();
        Example example = new Example(Post.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("authorId",userId);
        List<Post> posts = postMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(page1);
        map.put("pages",pageInfo.getPages());
        map.put("dataList",posts);
        return JSONResult.ok(map);
    }

    /**
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public JSONResult getPostList(Integer page, Integer pageSize) {
        Page page1 = PageHelper.startPage(page,pageSize);
        Map<String,Object> map = new HashMap<>();
        List<Post> posts = postMapper.selectAll();
        PageInfo pageInfo = new PageInfo<>(page1);
        map.put("pages",pageInfo.getPages());
        map.put("dataList",posts);
        return JSONResult.ok(map);
    }

    /**
     * @param page
     * @param pageSize
     * @param condition
     * @return
     */
    @Override
    public JSONResult queryPostListCondition(Integer page, Integer pageSize, String condition) {
            Page page1 = PageHelper.startPage(page,pageSize);
            Example example = new Example(Post.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("postTitle","%"+condition+"%");
            Map<String,Object> map = new HashMap<>();
            List<Post> posts = postMapper.selectByExample(example);
            PageInfo pageInfo = new PageInfo<>(page1);
            map.put("pages",pageInfo.getPages());
            map.put("dataList",posts);
            return JSONResult.ok(map);
    }
}
