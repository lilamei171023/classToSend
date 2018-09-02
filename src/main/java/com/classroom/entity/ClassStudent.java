package com.classroom.entity;

import java.io.Serializable;
import java.util.Date;


public class ClassStudent implements Serializable {
    private int classStudentId;
    private int studentId;
    private int classroomId;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;

    public ClassStudent() {
    }

    public ClassStudent(int classStudentId, int studentId, int classroomId, Date createAt, Date updateAt, boolean deleted) {
        this.classStudentId = classStudentId;
        this.studentId = studentId;
        this.classroomId = classroomId;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleted = deleted;
    }

    public int getClassStudentId() {
        return classStudentId;
    }

    public void setClassStudentId(int classStudentId) {
        this.classStudentId = classStudentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
        return "ClassStudent{" +
                "classStudentId=" + classStudentId +
                ", studentId=" + studentId +
                ", classroomId=" + classroomId +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted=" + deleted +
                '}';
    }
}
