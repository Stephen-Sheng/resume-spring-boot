package com.resume.resumespringboot.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@AllArgsConstructor
@ToString
public class CommentRelationshipBo {
    private String id;

    private String parentCommentId;

    private String childCommentId;
}