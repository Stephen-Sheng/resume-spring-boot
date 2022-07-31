package com.resume.resumespringboot.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Comment {
    @Id
    private String id;

    @Column(name = "posted_by")
    private String postedBy;

    @Column(name = "post_id")
    private String postId;

    @Column(name = "comment_date")
    private String commentDate;

    @Column(name = "reply_to")
    private String replyTo;

    @Column(name = "comment_text")
    private String commentText;

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
     * @return posted_by
     */
    public String getPostedBy() {
        return postedBy;
    }

    /**
     * @param postedBy
     */
    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    /**
     * @return post_id
     */
    public String getPostId() {
        return postId;
    }

    /**
     * @param postId
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }

    /**
     * @return comment_date
     */
    public String getCommentDate() {
        return commentDate;
    }

    /**
     * @param commentDate
     */
    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    /**
     * @return reply_to
     */
    public String getReplyTo() {
        return replyTo;
    }

    /**
     * @param replyTo
     */
    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    /**
     * @return comment_text
     */
    public String getCommentText() {
        return commentText;
    }

    /**
     * @param commentText
     */
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}