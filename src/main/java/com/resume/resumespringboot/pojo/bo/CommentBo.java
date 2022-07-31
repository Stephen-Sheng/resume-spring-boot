package com.resume.resumespringboot.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CommentBo {
    private String id;

    private String postedBy;

    private String postId;

    private String commentDate;

    private String replyTo;

    private String commentText;

}