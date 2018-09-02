package com.classroom.entity;

import java.io.Serializable;
import java.util.Date;

public class Datas implements Serializable{
    private int datasId;
    private String datasName;
    private String datasType;
    private String datasPath;
    private String datasGener;
    private String  teacherNumber;
    private int classroomId;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;

    public Datas() {
    }

    public Datas(int datasId, String datasName, String datasType, String datasPath, String datasGener, String teacherNumber, int classroomId, Date createAt, Date updateAt, boolean deleted) {
        this.datasId = datasId;
        this.datasName = datasName;
        this.datasType = datasType;
        this.datasPath = datasPath;
        this.datasGener = datasGener;
        this.teacherNumber = teacherNumber;
        this.classroomId = classroomId;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleted = deleted;
    }


    public int getDatasId() {
        return datasId;
    }

    public void setDatasId(int datasId) {
        this.datasId = datasId;
    }

    public String getDatasName() {
        return datasName;
    }

    public void setDatasName(String datasName) {
        this.datasName = datasName;
    }

    public String getDatasType() {
        return datasType;
    }

    public void setDatasType(String datasType) {
        this.datasType = datasType;
    }

    public String getDatasPath() {
        return datasPath;
    }

    public void setDatasPath(String datasPath) {
        this.datasPath = datasPath;
    }

    public String getDatasGener() {
        return datasGener;
    }

    public void setDatasGener(String datasGener) {
        this.datasGener = datasGener;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
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
        return "Datas{" +
                "datasId=" + datasId +
                ", datasName='" + datasName + '\'' +
                ", datasType='" + datasType + '\'' +
                ", datasPath='" + datasPath + '\'' +
                ", datasGener='" + datasGener + '\'' +
                ", teacherNumber='" + teacherNumber + '\'' +
                ", classroomId=" + classroomId +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted=" + deleted +
                '}';
    }
}
