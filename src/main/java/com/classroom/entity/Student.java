package com.classroom.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Lilamei
 * @date 2017/11/6
 */
public class Student implements Serializable{

    private  int     studentId;
    private  String  studentName;
    private  String  studentNo;
    private  String  studentNumber;
    private  String  studentSex;
    private  String  studentPwd;
    private  String  schoolName;
    private  String  studentPhoto;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;

    public Student() {
    }

    public Student(int studentId, String studentName, String studentNo, String studentNumber, String studentSex, String studentPwd, String schoolName, String studentPhoto, Date createAt, Date updateAt, boolean deleted) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentNo = studentNo;
        this.studentNumber = studentNumber;
        this.studentSex = studentSex;
        this.studentPwd = studentPwd;
        this.schoolName = schoolName;
        this.studentPhoto = studentPhoto;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleted = deleted;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStudentPhoto() {
        return studentPhoto;
    }

    public void setStudentPhoto(String studentPhoto) {
        this.studentPhoto = studentPhoto;
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
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", studentPwd='" + studentPwd + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", studentPhoto='" + studentPhoto + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted=" + deleted +
                '}';
    }
}
