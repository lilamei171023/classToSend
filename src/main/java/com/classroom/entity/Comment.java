package com.classroom.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{
    private int commentsId ;
    private int agreeCount;
    private int topicId ;
    private String content;
    private String userLoginNumber;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;

    public Comment() {
    }

    public Comment(int commentsId, int agreeCount, int topicId, String content, String userLoginNumber, Date createAt, Date updateAt, boolean deleted) {
        this.commentsId = commentsId;
        this.agreeCount = agreeCount;
        this.topicId = topicId;
        this.content = content;
        this.userLoginNumber = userLoginNumber;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleted = deleted;
    }

    public int getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(int commentsId) {
        this.commentsId = commentsId;
    }

    public int getAgreeCount() {
        return agreeCount;
    }

    public void setAgreeCount(int agreeCount) {
        this.agreeCount = agreeCount;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserLoginNumber() {
        return userLoginNumber;
    }

    public void setUserLoginNumber(String userLoginNumber) {
        this.userLoginNumber = userLoginNumber;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentsId=" + commentsId +
                ", agreeCount=" + agreeCount +
                ", topicId=" + topicId +
                ", content='" + content + '\'' +
                ", userLoginNumber='" + userLoginNumber + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted=" + deleted +
                '}';
    }
}
