package com.resume.resumespringboot.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "comment_relationship")
public class CommentRelationship {
    @Id
    private String id;

    @Column(name = "parent_comment_id")
    private String parentCommentId;

    @Column(name = "child_comment_id")
    private String childCommentId;

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
     * @return parent_comment_id
     */
    public String getParentCommentId() {
        return parentCommentId;
    }

    /**
     * @param parentCommentId
     */
    public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    /**
     * @return child_comment_id
     */
    public String getChildCommentId() {
        return childCommentId;
    }

    /**
     * @param childCommentId
     */
    public void setChildCommentId(String childCommentId) {
        this.childCommentId = childCommentId;
    }
}