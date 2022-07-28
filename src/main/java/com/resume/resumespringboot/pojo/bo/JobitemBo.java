package com.resume.resumespringboot.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class JobitemBo {
    private String id;

    private String itemname;

    private String salary;

    private String releasedate;

    private String feature;

    private String responsibility;

    private String ddl;

    private String location;

    private String degree;

    private String city;

    private String company;

    private String companyid;

}