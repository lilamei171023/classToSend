package com.classroom.vo.response;
import java.io.Serializable;

public class SearchStudentResult implements Serializable{
    private String student_name;
    private String student_no;
    private String student_sex;
    private String classroom_name;
    public String getClassroom_name() {
        return classroom_name;
    }

    public void setClassroom_name(String classroom_name) {
        this.classroom_name = classroom_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_no() {
        return student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    @Override
    public String toString() {
        return "SearchStudentResult{" +
                "student_name='" + student_name + '\'' +
                ", student_no='" + student_no + '\'' +
                ", student_sex='" + student_sex + '\'' +
                ", classroom_name='" + classroom_name + '\'' +
                '}';
    }
}
