package com.classroom.service.impl;

import com.classroom.BaseTest;
import com.classroom.entity.Student;
import com.classroom.service.IStudentService;
import com.classroom.vo.response.Msg;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiLaMei
 * @date 2017/11/7
 */
public class StudentServiceImplTest extends BaseTest {

    @Autowired
    private IStudentService iStudentService;

    @Test
    public void registerTest() throws Exception {

        Student student = new Student();
        student.setStudentName("王二女");
        student.setStudentNo("1559210223");
        student.setStudentSex("女");
        student.setStudentNumber("150700305");
        student.setStudentPwd("abcdefgh");
        student.setSchoolName("西安科技大学");
        System.out.println(iStudentService.register(student));
    }

    @Test
    public void updateStudentInformationTest() throws Exception {
        Msg msg = iStudentService.updateStudentInformation("150700305", "赵四", "1111111", "西安科技");
        System.out.println(msg);
    }

    @Test
    public void updatePwdTest() throws Exception {
        Msg msg = iStudentService.updatePwd("150700305", "aaaaaaaa");
        System.out.println(msg);
    }
    @Test
    public void searchStudentId() throws Exception {
        System.out.println(iStudentService.searchStudentId("345355"));
    }
    @Test
    public void agreeJoin() throws Exception {
        System.out.println(iStudentService.agreeJoin(3,1));
    }
    @Test
    public void selectByNo() throws Exception {
        System.out.println(iStudentService.selectByNo(1,"12234"));
    }
    @Test
    public void selectByName() throws Exception {
        System.out.println(iStudentService.selectByName(2,"马云1"));
    }
    @Test
    public void loadAllStudent() throws Exception{
        System.out.println(iStudentService.loadAllStudent(1,1));
    }
    @Test
    public void  deleteStudent() throws Exception {
        List<Integer> studentList=new ArrayList<>();
        studentList.add(1);
        studentList.add(2);
        System.out.println(iStudentService.deleteStudent(studentList,1));
    }

    @Test
    public void countStudent(){
        System.out.println(iStudentService.countStudent(1));
    }
    @Test
    public void  searchStudentIdByNo(){
        List<String> studentlist_no=new ArrayList<>();
        studentlist_no.add("12234");
        studentlist_no.add("12235");
        System.out.println(iStudentService.searchStudentIdByNo(studentlist_no));
    }

}