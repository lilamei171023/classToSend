package com.classroom.dao;

import com.classroom.BaseTest;
import com.classroom.entity.Teacher;
import com.classroom.vo.response.People;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class ITeacherDaoTest extends BaseTest {
    @Resource
    ITeacherDao iTeacherDao;

    @Test
    public void register() throws Exception {
        Teacher teacher=new Teacher();
        teacher.setTeacherName("李四");
        teacher.setTeacherNo("20001");
        teacher.setTeacherSex("男");
        teacher.setTeacherNumber("20001");
        teacher.setTeacherPwd("a11111888");
        teacher.setSchoolName("西安科技大学");
        teacher.setTeacherPhoto("photo");
        Integer test1;
        test1=iTeacherDao.register(teacher);
        Assert.assertTrue(test1==1);
    }

    @Test
    public void checkShortMessage() throws Exception {
       People teacher;
        teacher=iTeacherDao.checkShortMessage("20001");
       System.out.println(teacher.toString());
    }

    @Test
    public void update() throws Exception {
        Integer test1;
        test1=iTeacherDao.update("20001","王二","21001","西安交通大学");
       Assert.assertTrue(test1==1);
    }

    @Test
    public void updatePwd() throws Exception {
        Integer test1;
        test1=iTeacherDao.updatePwd("20001","111111111111111");
        Assert.assertTrue(test1==1);

    }
    @Test
    public void teacherJoin() throws Exception {
        System.out.println(iTeacherDao.teacherJion(3,1));
    }
    @Test
    public void searchTeacherName(){
        System.out.println(iTeacherDao.searchTeacherName(1));
    }
    @Test
    public void searchTeacherId() throws Exception {
        System.out.println(iTeacherDao.searchTeacherId("456777"));
    }
    @Test
    public void checkClassroom(){
        System.out.println(iTeacherDao.checkClassroom("34534"));

    }
}