package com.classroom.entity;

import java.io.Serializable;
import java.util.Date;

public class Classroom implements Serializable {

    private int      classroomId;
    private String   classroomName;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;

    public Classroom() {
    }

    public Classroom(int classroomId, String classroomName, Date createAt, Date updateAt, boolean deleted) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleted = deleted;
    }


    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
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
        return "Classroom{" +
                "classroomId=" + classroomId +
                ", classroomName='" + classroomName + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted=" + deleted +
                '}';
    }
}
