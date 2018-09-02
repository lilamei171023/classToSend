package com.classroom.service.impl;

import com.classroom.BaseTest;
import com.classroom.entity.CheckOne;
import com.classroom.entity.Evaluation;
import com.classroom.service.ICheckingService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CheckingServiceImplTest extends BaseTest{
    @Autowired
    private ICheckingService checkingService;

    @Test
    public void checking1() {
        //根据班级id查询该班级所有学生
        int classroomId=1;

        List<String > list = new ArrayList<>();
        list = checkingService.loadAllStudent(classroomId);
        int sum=checkingService.selectCheckOne();
        System.out.println("-------"+sum+"------------");
        List<CheckOne> check = new ArrayList<>();
        int mark;
        if(sum==0){
            mark=1;
            System.out.println("----------" + list + "---------");
            Evaluation evaluation=new Evaluation();
            CheckOne checkOne = new CheckOne();
            for (String  studentNumber : list) {
                checkOne.setStudentNumber(studentNumber);
                checkOne.setClassroomId(classroomId);
                checkOne.setMark(mark);
                check.add(checkOne);
                int number = checkingService.insertOneStudent(check);
                check.clear();
                if (number > 0) {
                    int totalSum=mark;
                    evaluation.setStudentNumber(studentNumber);
                    evaluation.setClassroomId(classroomId);
                    evaluation.setTotalSum(totalSum);
                    List<Evaluation> list1=new ArrayList<>();
                    list1.add(evaluation);
                    checkingService.insertFirstStudent(list1);
                    list1.clear();
                }
            }
        }else {
            CheckOne checkOne = new CheckOne();
            for (String  student_number : list) {
                checkOne.setStudentNumber(student_number);
                checkOne.setClassroomId(classroomId);
                check.add(checkOne);
                mark=checkingService.selectMaxMark(check);
                mark++;
                check.clear();
                checkOne.setStudentNumber(student_number);
                checkOne.setClassroomId(classroomId);
                checkOne.setMark(mark);
                check.add(checkOne);
                checkingService.insertOneStudent(check);
                check.clear();
            }
        }
    }
    @Test
    public void checking2(){
        String  studentNumber="100001";

        int classroomId=checkingService.select(studentNumber);
        CheckOne checkOne=new CheckOne();
        List<CheckOne> c=new ArrayList<>();
        checkOne.setStudentNumber(studentNumber);
        checkOne.setClassroomId(classroomId);
        c.add(checkOne);
        int mark=checkingService.selectMaxMark(c);
        mark--;
        c.clear();
        checkOne.setStudentNumber(studentNumber);
        checkOne.setClassroomId(classroomId);
        checkOne.setMark(mark);
        c.add(checkOne);
        int count=checkingService.updateCheckOne(c);
        if(count>0){
            Evaluation evaluation=new Evaluation();
            List<Evaluation> e=new ArrayList<>();
            evaluation.setStudentNumber(studentNumber);
            evaluation.setClassroomId(classroomId);
            e.add(evaluation);
            Evaluation ev;
            ev=checkingService.selectEvaluation(e);
            e.clear();
            evaluation.setTotalAttendanceCount(ev.getTotalAttendanceCount());
            evaluation.setTotalSum(ev.getTotalSum());
            evaluation.setStudentNumber(studentNumber);
            evaluation.setClassroomId(classroomId);
            e.add(evaluation);
            int count1=checkingService.updateEvaluation(e);
            System.out.println(count1);
        }
    }
}
