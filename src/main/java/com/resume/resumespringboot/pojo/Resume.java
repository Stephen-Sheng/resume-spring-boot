package com.resume.resumespringboot.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Resume {
    @Id
    private String id;

    @Column(name = "userId")
    private String userid;

    @Column(name = "userName")
    private String username;

    @Column(name = "phoneNum")
    private String phonenum;

    private String email;

    @Column(name = "workLocation")
    private String worklocation;

    @Column(name = "photoUrl")
    private String photourl;

    @Column(name = "resumeName")
    private String resumename;

    @Column(name = "eduInfo")
    private String eduinfo;

    @Column(name = "projectInfo")
    private String projectinfo;

    @Column(name = "orgInfo")
    private String orginfo;

    @Column(name = "profSkills")
    private String profskills;

    @Column(name = "otherSkills")
    private String otherskills;

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
     * @return userId
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return phoneNum
     */
    public String getPhonenum() {
        return phonenum;
    }

    /**
     * @param phonenum
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return workLocation
     */
    public String getWorklocation() {
        return worklocation;
    }

    /**
     * @param worklocation
     */
    public void setWorklocation(String worklocation) {
        this.worklocation = worklocation;
    }

    /**
     * @return photoUrl
     */
    public String getPhotourl() {
        return photourl;
    }

    /**
     * @param photourl
     */
    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    /**
     * @return resumeName
     */
    public String getResumename() {
        return resumename;
    }

    /**
     * @param resumename
     */
    public void setResumename(String resumename) {
        this.resumename = resumename;
    }

    /**
     * @return eduInfo
     */
    public String getEduinfo() {
        return eduinfo;
    }

    /**
     * @param eduinfo
     */
    public void setEduinfo(String eduinfo) {
        this.eduinfo = eduinfo;
    }

    /**
     * @return projectInfo
     */
    public String getProjectinfo() {
        return projectinfo;
    }

    /**
     * @param projectinfo
     */
    public void setProjectinfo(String projectinfo) {
        this.projectinfo = projectinfo;
    }

    /**
     * @return orgInfo
     */
    public String getOrginfo() {
        return orginfo;
    }

    /**
     * @param orginfo
     */
    public void setOrginfo(String orginfo) {
        this.orginfo = orginfo;
    }

    /**
     * @return profSkills
     */
    public String getProfskills() {
        return profskills;
    }

    /**
     * @param profskills
     */
    public void setProfskills(String profskills) {
        this.profskills = profskills;
    }

    /**
     * @return otherSkills
     */
    public String getOtherskills() {
        return otherskills;
    }

    /**
     * @param otherskills
     */
    public void setOtherskills(String otherskills) {
        this.otherskills = otherskills;
    }
}