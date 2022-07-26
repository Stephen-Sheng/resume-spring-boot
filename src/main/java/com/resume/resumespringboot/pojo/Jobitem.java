package com.resume.resumespringboot.pojo;

import javax.persistence.*;

public class Jobitem {
    @Id
    private String id;

    private String itemname;

    private String salary;

    private String releasedate;

    private String feature;

    private String ddl;

    private String location;

    private String degree;

    private String city;

    private String company;

    private String responsibility;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return itemname
     */
    public String getItemname() {
        return itemname;
    }

    /**
     * @param itemname
     */
    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    /**
     * @return salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * @return releasedate
     */
    public String getReleasedate() {
        return releasedate;
    }

    /**
     * @param releasedate
     */
    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    /**
     * @return feature
     */
    public String getFeature() {
        return feature;
    }

    /**
     * @param feature
     */
    public void setFeature(String feature) {
        this.feature = feature;
    }

    /**
     * @return ddl
     */
    public String getDdl() {
        return ddl;
    }

    /**
     * @param ddl
     */
    public void setDdl(String ddl) {
        this.ddl = ddl;
    }

    /**
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return degree
     */
    public String getDegree() {
        return degree;
    }

    /**
     * @param degree
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return responsibility
     */
    public String getResponsibility() {
        return responsibility;
    }

    /**
     * @param responsibility
     */
    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }
}