package com.resume.resumespringboot.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@ToString
public class ResumeBo {

    private String id;
    @NotBlank
    private String userid;

    private String username;

    private String phonenum;

    private String email;

    private String worklocation;

    private String photourl;

    private String resumename;

    private String eduinfo;

    private String projectinfo;

    private String orginfo;

    private String profskills;

    private String otherskills;
}
