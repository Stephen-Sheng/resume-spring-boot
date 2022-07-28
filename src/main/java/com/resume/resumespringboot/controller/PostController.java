package com.resume.resumespringboot.controller;

import com.resume.resumespringboot.service.CommentService;
import com.resume.resumespringboot.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
