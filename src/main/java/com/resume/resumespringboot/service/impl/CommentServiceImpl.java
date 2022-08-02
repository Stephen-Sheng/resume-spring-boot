package com.resume.resumespringboot.service.impl;

import com.resume.resumespringboot.mapper.CommentCustomMapper;
import com.resume.resumespringboot.mapper.CommentMapper;
import com.resume.resumespringboot.pojo.Comment;
import com.resume.resumespringboot.pojo.User;
import com.resume.resumespringboot.service.CommentService;
import com.resume.resumespringboot.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    private final CommentCustomMapper commentCustomMapper;

    @Autowired
    public CommentServiceImpl(@Lazy CommentMapper commentMapper,@Lazy CommentCustomMapper commentCustomMapper) {
        this.commentMapper = commentMapper;
        this.commentCustomMapper = commentCustomMapper;
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

        List<Map<String,String>> comments = commentCustomMapper.queryCommentListByPostId(postId);
        List<Map<String,Object>> finalList = new ArrayList<>();
        for(Map<String,String> comment : comments){
            List<Map<String,Object>> finalList2 = new ArrayList<>();
            List<Map<String,String>> itemArr = commentCustomMapper.queryCommentItemByParent(comment.get("comId"));
            if(!itemArr.isEmpty()){
                Map<String,Object> map = new HashMap<>();
                map.put("comId",comment.get("comId"));
                map.put("userId",comment.get("userId"));
                map.put("text",comment.get("text"));
                map.put("fullName",comment.get("fullName"));
                map.put("avatarUrl","https://ui-avatars.com/api/name="+comment.get("fullName")+"&background=random");
                map.put("userProfile","");
                for(Map<String,String> item : itemArr){
                    Map<String,Object> map2 = new HashMap<>();
                    map2.put("comId",item.get("comId"));
                    map2.put("userId",item.get("userId"));
                    map2.put("text",item.get("text"));
                    map2.put("fullName",item.get("fullName"));
                    map2.put("avatarUrl","https://ui-avatars.com/api/name="+item.get("fullName")+"&background=random");
                    map2.put("userProfile","");
                    map2.put("replies",new ArrayList<>());
                    finalList2.add(map2);
                }
                map.put("replies",finalList2);
                finalList.add(map);
            }else{
                List<Map<String,String>> itemArr2 = commentCustomMapper.queryCommentItemByChild(comment.get("comId"));
                if(itemArr2.isEmpty()){
                    Map<String,Object> map3 = new HashMap<>();
                    map3.put("comId",comment.get("comId"));
                    map3.put("userId",comment.get("userId"));
                    map3.put("text",comment.get("text"));
                    map3.put("fullName",comment.get("fullName"));
                    map3.put("avatarUrl","https://ui-avatars.com/api/name="+comment.get("fullName")+"&background=random");
                    map3.put("userProfile","");
                    map3.put("replies",new ArrayList<>());
                    finalList.add(map3);
                }
            }
        }
        return JSONResult.ok(finalList);
    }


    @Override
    public JSONResult updateComment(Comment comment) {
        commentMapper.updateByPrimaryKeySelective(comment);
        return JSONResult.ok();
    }
}
