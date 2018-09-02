package com.classroom.entity;

import java.io.Serializable;
import java.util.Date;

public class CheckOne implements Serializable {
    private int checkId;
    private int mark;
    private int classroomId;
    private Enum flag;
    private String studentNumber;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;

    public CheckOne() {
    }

    public CheckOne(int checkId, int mark, int classroomId, Enum flag, String studentNumber, Date createAt, Date updateAt, boolean deleted) {
        this.checkId = checkId;
        this.mark = mark;
        this.classroomId = classroomId;
        this.flag = flag;
        this.studentNumber = studentNumber;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleted = deleted;
    }

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public Enum getFlag() {
        return flag;
    }

    public void setFlag(Enum flag) {
        this.flag = flag;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
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
        return "CheckOne{" +
                "checkId=" + checkId +
                ", mark=" + mark +
                ", classroomId=" + classroomId +
                ", flag=" + flag +
                ", studentNumber='" + studentNumber + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted=" + deleted +
                '}';
    }
}
