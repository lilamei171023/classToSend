package com.classroom.entity;

import java.io.Serializable;
import java.util.Date;

public class ClassTeacher implements Serializable{
    private int classTeacherId;
    private int teacherId;
    private int classroomId;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;

    public ClassTeacher() {
    }

    public ClassTeacher(int classTeacherId, int teacherId, int classroomId, Date createAt, Date updateAt, boolean deleted) {
        this.classTeacherId = classTeacherId;
        this.teacherId = teacherId;
        this.classroomId = classroomId;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleted = deleted;
    }

    public int getClassTeacherId() {
        return classTeacherId;
    }

    public void setClassTeacherId(int classTeacherId) {
        this.classTeacherId = classTeacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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
        return "ClassTeacher{" +
                "classTeacherId=" + classTeacherId +
                ", teacherId=" + teacherId +
                ", classroomId=" + classroomId +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted=" + deleted +
                '}';
    }
}
