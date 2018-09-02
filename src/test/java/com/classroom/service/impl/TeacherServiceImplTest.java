package com.classroom.service.impl;

import com.classroom.BaseTest;
import com.classroom.entity.Teacher;
import com.classroom.service.ITeacherService;
import com.classroom.vo.response.Msg;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LiLaMei
 * @date 2017/11/7
 */
public class TeacherServiceImplTest extends BaseTest {

    @Autowired
    private ITeacherService iTeacherService;


    @Test
    public void register() throws Exception {
        Teacher teacher=new Teacher();
        teacher.setTeacherName("李四");
        teacher.setTeacherNo("2222");
        teacher.setTeacherSex("男");
        teacher.setTeacherNumber("a888888888");
        teacher.setTeacherPwd("a11111888");
        teacher.setSchoolName("西安科技大学");
        Msg msg=iTeacherService.register(teacher);
        System.out.println(msg);

    }

    @Test
   public  void updateTeacherInformationTest() throws Exception{
       Msg msg=iTeacherService.updateTeacherInformation("a888888888","王二","11222","西外");
       System.out.println(msg);
    }


    @Test
    public  void updatePwdTest()throws Exception{
        Msg msg=iTeacherService.updatePwd("a888888888","dddd2222");
        System.out.println(msg);
    }

    @Test
    public void teacherJoin() throws Exception {
        System.out.println(iTeacherService.teacherJion(2,1));
    }
    @Test
    public void searchTeacherName(){
        System.out.println(iTeacherService.searchTeacherName(1));
    }
    @Test
    public void searchTeacherId() throws Exception {
        System.out.println(iTeacherService.searchTeacherId("34535"));
    }
    @Test
    public void checkClassroom(){
        System.out.println(iTeacherService.checkClassroom("34534"));
    }






}