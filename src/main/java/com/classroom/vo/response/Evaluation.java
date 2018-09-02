package com.classroom.vo.response;
import java.io.Serializable;

public class Evaluation implements Serializable{
    private int total_attendance_count;
    private int total_sum;
    private int homework_count;
    private int homework_sum;
    private String total_score;

    public int getTotal_attendance_count() {
        return total_attendance_count;
    }

    public void setTotal_attendance_count(int total_attendance_count) {
        this.total_attendance_count = total_attendance_count;
    }

    public int getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(int total_sum) {
        this.total_sum = total_sum;
    }

    public int getHomework_count() {
        return homework_count;
    }

    public void setHomework_count(int homework_count) {
        this.homework_count = homework_count;
    }

    public int getHomework_sum() {
        return homework_sum;
    }

    public void setHomework_sum(int homework_sum) {
        this.homework_sum = homework_sum;
    }

    public String getTotal_score() {
        return total_score;
    }

    public void setTotal_score(String total_score) {
        this.total_score = total_score;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "total_attendance_count=" + total_attendance_count +
                ", total_sum=" + total_sum +
                ", homework_count=" + homework_count +
                ", homework_sum=" + homework_sum +
                ", total_score='" + total_score + '\'' +
                '}';
    }
}
