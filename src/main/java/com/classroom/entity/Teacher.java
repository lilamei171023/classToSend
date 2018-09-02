package com.classroom.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Lilamei
 * @date 2017/11/6
 */
public class Teacher implements Serializable{

    private  int     teacherId;
    private  String  teacherName;
    private  String  teacherNo;
    private  String  teacherNumber;
    private  String  teacherSex;
    private  String  teacherPwd;
    private  String  teacherPhoto;
    private  String  schoolName;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;

    public Teacher() {
    }

    public Teacher(int teacherId, String teacherName, String teacherNo, String teacherNumber, String teacherSex, String teacherPwd, String teacherPhoto, String schoolName, Date createAt, Date updateAt, boolean deleted) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherNo = teacherNo;
        this.teacherNumber = teacherNumber;
        this.teacherSex = teacherSex;
        this.teacherPwd = teacherPwd;
        this.teacherPhoto = teacherPhoto;
        this.schoolName = schoolName;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleted = deleted;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd;
    }

    public String getTeacherPhoto() {
        return teacherPhoto;
    }

    public void setTeacherPhoto(String teacherPhoto) {
        this.teacherPhoto = teacherPhoto;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherNo='" + teacherNo + '\'' +
                ", teacherNumber='" + teacherNumber + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", teacherPwd='" + teacherPwd + '\'' +
                ", teacherPhoto='" + teacherPhoto + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted=" + deleted +
                '}';
    }
}
