package com.classroom.vo.response;
public class RTeacher {
    private String teacher_name;
    public String getTeacher_name() {
        return teacher_name;
    }
    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_name='" + teacher_name + '\'' +
                '}';
    }
}
