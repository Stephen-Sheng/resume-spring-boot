package com.resume.resumespringboot.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Post {
    @Id
    private String id;

    @Column(name = "author_id")
    private String authorId;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_date")
    private String postDate;

    private String category;

    private String cover;

    @Column(name = "post_text")
    private String postText;

    private String summary;

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
     * @return author_id
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * @return post_title
     */
    public String getPostTitle() {
        return postTitle;
    }

    /**
     * @param postTitle
     */
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    /**
     * @return post_date
     */
    public String getPostDate() {
        return postDate;
    }

    /**
     * @param postDate
     */
    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    /**
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return cover
     */
    public String getCover() {
        return cover;
    }

    /**
     * @param cover
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * @return post_text
     */
    public String getPostText() {
        return postText;
    }

    /**
     * @param postText
     */
    public void setPostText(String postText) {
        this.postText = postText;
    }

    /**
     * @return summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }
}