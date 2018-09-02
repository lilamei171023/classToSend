package com.classroom.controller;

import com.classroom.entity.CheckOne;
import com.classroom.entity.Evaluation;
import com.classroom.service.ICheckingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes
/*
* 考勤.签到接口
* */
public class CheckingController {
    @Resource
    private ICheckingService checkingService;

    private String codeone;

    //获取验证码
   @ResponseBody
   @RequestMapping("checking/gainCode")
    public String gainCode(){
       int code1=(int)Math.random()*10;
       int code2=(int)Math.random()*10;
       int code3=(int)Math.random()*10;
       int code4=(int)Math.random()*10;

       String code="code4"+"code3"+"code2"+"code1";
       this.codeone=code;
       return code;
   }
    /*
    * 老师在班级内点击签到
    * */
    @ResponseBody
    @RequestMapping("checking/teacherChecking")
    public void teacherChecking(@RequestParam int classroomId) {
        List<String > list = new ArrayList<>();
        //根据班级id查询该班级所有学生
        list = checkingService.loadAllStudent(classroomId);
        //查询checkOne表是否有数据 判断是否是第一次考勤
        int sum=checkingService.selectCheckOne();
        List<CheckOne> check = new ArrayList<>();
        int mark;
        if(sum==0){
            mark=1;
            Evaluation evaluation=new Evaluation();
            CheckOne checkOne = new CheckOne();
            for (String  studentNumber : list) {
                checkOne.setStudentNumber(studentNumber);
                checkOne.setClassroomId(classroomId);
                checkOne.setMark(mark);
                check.add(checkOne);
                //建立checkOne表的第一次数据
                int number = checkingService.insertOneStudent(check);
                check.clear();
                if (number > 0) {//往check_one表添加数据执行成功
                    int totalSum=mark;
                    evaluation.setStudentNumber(studentNumber);
                    evaluation.setClassroomId(classroomId);
                    evaluation.setTotalSum(totalSum);
                    List<Evaluation> list1=new ArrayList<>();
                    list1.add(evaluation);
                    //在evaluation表也建立对应信息
                    checkingService.insertFirstStudent(list1);
                    list1.clear();
                }
            }
        }else {
            CheckOne checkOne = new CheckOne();
            for (String  studentNumber : list) {
                checkOne.setStudentNumber(studentNumber);
                checkOne.setClassroomId(classroomId);
                check.add(checkOne);
                mark=checkingService.selectMaxMark(check);
                mark++;
                check.clear();
                checkOne.setStudentNumber(studentNumber);
                checkOne.setClassroomId(classroomId);
                checkOne.setMark(mark);
                check.add(checkOne);
                checkingService.insertOneStudent(check);
                check.clear();
            }
        }
    }
    /*
    * 学生签到接口
    * */
   @ResponseBody
   @RequestMapping("checking/checkingStudent")
    public boolean checkingStudent(@RequestParam String studentNumber){
       boolean bool=false;
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
               if(count1>0){
                   bool=true;
           }
       }
        return  bool;
    }
}
