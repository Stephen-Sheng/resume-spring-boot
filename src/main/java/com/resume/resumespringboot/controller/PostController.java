package com.resume.resumespringboot.controller;

import com.resume.resumespringboot.pojo.Jobitem;
import com.resume.resumespringboot.pojo.Post;
import com.resume.resumespringboot.pojo.bo.JobitemBo;
import com.resume.resumespringboot.pojo.bo.PostBo;
import com.resume.resumespringboot.service.CommentService;
import com.resume.resumespringboot.service.PostService;
import com.resume.resumespringboot.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
public class PostController {
    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public PostController(@Lazy PostService postService, @Lazy CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @PostMapping("insert-post")
    public JSONResult insertJob(@Valid @RequestBody PostBo map, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = UserController.getErrors(bindingResult);
            return JSONResult.errorMap(errorMap);
        }
        String uid = UUID.randomUUID().toString();
        Post post = new Post();
        BeanUtils.copyProperties(map, post);
        post.setId(uid);
        JSONResult jsonResult = postService.savePost(post);

        return jsonResult;
    }

    @GetMapping("deletePost/{postId}")
    public JSONResult deletePost(@PathVariable String postId){
        JSONResult jsonResult = postService.deletePost(postId);
        return jsonResult;
    }

    @GetMapping("findPostById/{postId}")
    public JSONResult findPostById(@PathVariable String postId){
        JSONResult jsonResult = postService.queryPostById(postId);
        return jsonResult;
    }

    @GetMapping("findPostsByUserId/{userId}/{page}")
    public JSONResult findPostsByUserId(@PathVariable String userId, @PathVariable Integer page){
        if (page == null) {
            page = 1;
        }
        int pageSize = 3;
        JSONResult jsonResult = postService.queryPostListByUserId(page,pageSize,userId);
        return jsonResult;
    }

    @GetMapping("getPostsList/{page}")
    public JSONResult getPostsList(@PathVariable Integer page){
        if (page == null){
            page=1;
        }
        int pageSize =3;
        JSONResult jsonResult = postService.getPostList(page,pageSize);
        return jsonResult;
    }

    @GetMapping("searchByCondition/{condition}/{page}")
    public JSONResult searchByCondition(@PathVariable String condition, @PathVariable Integer page){
        if (page == null) {
            page = 1;
        }
        int pageSize = 3;
        JSONResult jsonResult = postService.queryPostListCondition(page,pageSize,condition);
        return jsonResult;
    }



}
