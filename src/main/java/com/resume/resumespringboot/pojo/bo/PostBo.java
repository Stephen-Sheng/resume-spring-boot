package com.resume.resumespringboot.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class PostBo {
    private String id;

    private String authorId;

    private String postTitle;

    private String postDate;

    private String category;

    private String postText;
}