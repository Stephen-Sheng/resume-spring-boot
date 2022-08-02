package com.resume.resumespringboot.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

public interface CommentCustomMapper {

    @Select("SELECT comment.id as comId,comment.comment_text as text,comment.posted_by as userId,user.username as fullName FROM comment JOIN comment_relationship ON comment.id = comment_relationship.child_comment_id JOIN user ON comment.posted_by = user.id WHERE comment_relationship.parent_comment_id=#{commentId}")
    public List<Map<String,String>> queryCommentItemByParent(@Param("commentId") String commentId);

    @Select("SELECT comment.id as comId,comment.comment_text as text,comment.posted_by as userId,user.username as fullName FROM comment JOIN user ON comment.posted_by = user.id WHERE comment.post_id = #{postId}")
    public  List<Map<String,String>> queryCommentListByPostId(@Param("postId") String postId);

    @Select("SELECT comment.id as comId,comment.comment_text as text,comment.posted_by as userId,user.username as fullName FROM comment JOIN comment_relationship ON comment.id = comment_relationship.child_comment_id JOIN user ON comment.posted_by = user.id WHERE comment_relationship.child_comment_id=#{commentId}")
    public List<Map<String,String>> queryCommentItemByChild(@Param("commentId") String commentId);
}