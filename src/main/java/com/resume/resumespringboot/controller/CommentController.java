package com.resume.resumespringboot.controller;

import com.resume.resumespringboot.pojo.Comment;
import com.resume.resumespringboot.pojo.CommentRelationship;
import com.resume.resumespringboot.pojo.Jobitem;
import com.resume.resumespringboot.pojo.Post;
import com.resume.resumespringboot.pojo.bo.CommentBo;
import com.resume.resumespringboot.pojo.bo.JobitemBo;
import com.resume.resumespringboot.pojo.bo.PostBo;
import com.resume.resumespringboot.service.CommentRelationService;
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
public class CommentController {
    private final CommentService commentService;
    private final CommentRelationService commentRelationService;

    @Autowired
    public CommentController(@Lazy CommentService commentService,@Lazy CommentRelationService commentRelationService) {
        this.commentService = commentService;
        this.commentRelationService = commentRelationService;
    }

    @PostMapping("insert-comment")
    public JSONResult insertComment(@Valid @RequestBody CommentBo map, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = UserController.getErrors(bindingResult);
            return JSONResult.errorMap(errorMap);
        }
        Comment comment = new Comment();
        BeanUtils.copyProperties(map, comment);
        JSONResult jsonResult = commentService.saveComment(comment);

        return jsonResult;
    }

    @PostMapping("insert-childComment")
    public JSONResult insertChildComment(@Valid @RequestBody CommentRelationship map, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = UserController.getErrors(bindingResult);
            return JSONResult.errorMap(errorMap);
        }
        String uid = UUID.randomUUID().toString();
        CommentRelationship commentRelationship = new CommentRelationship();
        BeanUtils.copyProperties(map, commentRelationship);
        commentRelationship.setId(uid);
        commentRelationService.insertRelation(commentRelationship);
        return JSONResult.ok();
    }

    @GetMapping("findCommentsByPostId/{postId}")
    public JSONResult findCommentsByPostId(@PathVariable String postId){
        JSONResult jsonResult = commentService.queryCommentByPostId(postId);
        return jsonResult;
    }

    @GetMapping("deleteParentComment/{commentId}")
    public JSONResult deleteComment(@PathVariable String commentId){

        commentRelationService.deleteParentRelation(commentId);
        JSONResult jsonResult = commentService.deleteComment(commentId);
        return jsonResult;
    }

    @GetMapping("deleteChildComment/{parentId}/{childId}")
    public JSONResult deleteChildComment(@PathVariable String parentId,@PathVariable String childId){
        commentRelationService.deleteRelation(parentId, childId);
        JSONResult jsonResult = commentService.deleteComment(childId);
        return jsonResult;

    }

    @PostMapping("updateComment")
    public JSONResult updateComment(@Valid @RequestBody Comment comment){
        JSONResult jsonResult = commentService.updateComment(comment);
        return jsonResult;
    }


}

