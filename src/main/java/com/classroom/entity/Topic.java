package com.classroom.entity;

import java.io.Serializable;
import java.util.Date;

public class Topic implements Serializable{
    private int topicId;
    private int agreeCount;
    private int scanTimes;
    private int commentsTimes;
    private String topicTitle;
    private String topicContent;
    private String userLoginNumber;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getUserLoginNumber() {
        return userLoginNumber;
    }

    public void setUserLoginNumber(String userLoginNumber) {
        this.userLoginNumber = userLoginNumber;
    }

    public int getAgreeCount() {
        return agreeCount;
    }

    public void setAgreeCount(int agreeCount) {
        this.agreeCount = agreeCount;
    }

    public int getScanTimes() {
        return scanTimes;
    }

    public void setScanTimes(int scanTimes) {
        this.scanTimes = scanTimes;
    }

    public Date getCreateAt() {
        return createAt;
    }



    public int getCommentsTimes() {
        return commentsTimes;

    }

    public void setCommentsTimes(int commentsTimes) {
        this.commentsTimes = commentsTimes;
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
        return "Topic{" +
                "topicId=" + topicId +
                ", topicTitle='" + topicTitle + '\'' +
                ", topicContent='" + topicContent + '\'' +
                ", userLoginNumber='" + userLoginNumber + '\'' +
                ", agreeCount=" + agreeCount +
                ", scanTimes=" + scanTimes +
                ", commentsTimes=" + commentsTimes +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted=" + deleted +
                '}';
    }

    public Topic() {
    }

    public Topic(int topicId, String topicTitle, String topicContent, String userLoginNumber, int agreeCount, int scanTimes, int commentsTimes, Date createAt, Date updateAt, boolean deleted) {
        this.topicId = topicId;
        this.topicTitle = topicTitle;
        this.topicContent = topicContent;
        this.userLoginNumber = userLoginNumber;
        this.agreeCount = agreeCount;
        this.scanTimes = scanTimes;
        this.commentsTimes = commentsTimes;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleted = deleted;
    }

}
