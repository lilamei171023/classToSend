package com.classroom.entity;

import java.io.Serializable;
import java.util.Date;

public class Homework implements Serializable{
    private int homeworkId;
    private String homeworkName;
    private String homeworkPath;
    private String homeworkType;
    private String homeworkGrade;
    private String studentNumber;
    private int classroomId;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;

    public Homework() {
    }

    public Homework(int homeworkId, String homeworkName, String homeworkPath, String homeworkType, String homeworkGrade, String studentNumber, int classroomId, Date createAt, Date updateAt, boolean deleted) {
        this.homeworkId = homeworkId;
        this.homeworkName = homeworkName;
        this.homeworkPath = homeworkPath;
        this.homeworkType = homeworkType;
        this.homeworkGrade = homeworkGrade;
        this.studentNumber = studentNumber;
        this.classroomId = classroomId;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleted = deleted;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    public String getHomeworkPath() {
        return homeworkPath;
    }

    public void setHomeworkPath(String homeworkPath) {
        this.homeworkPath = homeworkPath;
    }

    public String getHomeworkType() {
        return homeworkType;
    }

    public void setHomeworkType(String homeworkType) {
        this.homeworkType = homeworkType;
    }

    public String getHomeworkGrade() {
        return homeworkGrade;
    }

    public void setHomeworkGrade(String homeworkGrade) {
        this.homeworkGrade = homeworkGrade;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
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
        return "Homework{" +
                "homeworkId=" + homeworkId +
                ", homeworkName='" + homeworkName + '\'' +
                ", homeworkPath='" + homeworkPath + '\'' +
                ", homeworkType='" + homeworkType + '\'' +
                ", homeworkGrade='" + homeworkGrade + '\'' +
                ", stduentNumber='" + studentNumber + '\'' +
                ", classroomId=" + classroomId +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted=" + deleted +
                '}';
    }
}
