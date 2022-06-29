package com.resume.resumespringboot.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@ToString
public class JobBo {
    private String id;
    @NotBlank
    private String company;
    @NotBlank
    private String location;
    @NotBlank
    private String ddl;

    private String description;
    @NotBlank
    private String logo;
    @NotBlank
    private String website;
    @NotBlank
    private String detail;

}