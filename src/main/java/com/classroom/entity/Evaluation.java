package com.classroom.entity;

import java.io.Serializable;
import java.util.Date;

public class Evaluation implements Serializable {
    private int evaluationId;
    private int totalAttendanceCount;
    private int totalSum;
    private  int classroomId;
    private String studentNumber;
    private int homeworkCount;
    private int homeworkSum;
    private String totalScore;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;

    public Evaluation() {
    }

    public Evaluation(int evaluationId, int totalAttendanceCount, int totalSum, int classroomId, String studentNumber, int homeworkCount, int homeworkSum, String totalScore, Date createAt, Date updateAt, boolean deleted) {
        this.evaluationId = evaluationId;
        this.totalAttendanceCount = totalAttendanceCount;
        this.totalSum = totalSum;
        this.classroomId = classroomId;
        this.studentNumber = studentNumber;
        this.homeworkCount = homeworkCount;
        this.homeworkSum = homeworkSum;
        this.totalScore = totalScore;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleted = deleted;
    }

    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public int getTotalAttendanceCount() {
        return totalAttendanceCount;
    }

    public void setTotalAttendanceCount(int totalAttendanceCount) {
        this.totalAttendanceCount = totalAttendanceCount;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getHomeworkCount() {
        return homeworkCount;
    }

    public void setHomeworkCount(int homeworkCount) {
        this.homeworkCount = homeworkCount;
    }

    public int getHomeworkSum() {
        return homeworkSum;
    }

    public void setHomeworkSum(int homeworkSum) {
        this.homeworkSum = homeworkSum;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
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
        return "Evaluation{" +
                "evaluationId=" + evaluationId +
                ", totalAttendanceCount=" + totalAttendanceCount +
                ", totalSum=" + totalSum +
                ", studentId=" + classroomId +
                ", studentNumber='" + studentNumber + '\'' +
                ", homeworkCount=" + homeworkCount +
                ", homeworkSum=" + homeworkSum +
                ", totalScore='" + totalScore + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted=" + deleted +
                '}';
    }
}
