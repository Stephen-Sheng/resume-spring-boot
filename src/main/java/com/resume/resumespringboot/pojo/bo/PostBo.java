package com.resume.resumespringboot.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@ToString
public class PostBo {
    private String id;
    @NotBlank
    private String authorId;
    @NotBlank

    private String postTitle;
    @NotBlank

    private String postDate;
    @NotBlank

    private String category;
    @NotBlank

    private String postText;

    private String summary;
    private String cover;


}