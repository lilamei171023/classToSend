package com.classroom.dao;

import com.alibaba.fastjson.JSON;
import com.classroom.BaseTest;
import com.classroom.entity.Student;
import com.classroom.vo.response.People;
import com.classroom.vo.response.SearchStudentResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lilamei
 * @date 2017/11/7 17:10
 */
public class IStudentDaoTest extends BaseTest {


    @Resource
    private  IStudentDao iStudentDao;

    @Test
      public void testRegister( ) throws Exception {

        Student student=new Student();
        student.setStudentName("李四");
        student.setStudentNo("10008");
        student.setStudentSex("男");
        student.setStudentNumber("10008");
        student.setStudentPwd("123456789a");
        student.setSchoolName("西安科技大学");
        student.setStudentPhoto("phone");
        Integer test1=iStudentDao.register(student);
       // System.out.println(test4);
        Assert.assertTrue(test1==1);
    }

    @Test
    public void checkShortMessageTest()throws  Exception{
      People people=iStudentDao.checkShortMessage("1001");
      System.out.println(people.toString());
    }

    @Test
    public void updateTest()throws Exception{
        iStudentDao.update("1000023","张三丰","12001","西北大学");
    }

    @Test
    public void updatePwdTest()throws Exception{
        Integer test1=iStudentDao.updatePwd("10001","1234567890");
        Assert.assertTrue(test1==1);
    }

    @Test
    public void searchStudentId() throws Exception {
        System.out.println(iStudentDao.searchStudentId("71625353734"));
    }
    @Test
    public void selectByName() throws Exception{
        System.out.println(iStudentDao.selectByName("马云1",1));
    }
    @Test
    public void selectByNo() throws Exception{
        System.out.println(iStudentDao.selectByNo("12234",1));
    }
    @Test
    public void agreeJoin() throws Exception {
        System.out.println(iStudentDao.agreeJoin(3,1));
    }
    @Test
    public void deleteStudent() throws Exception{
        List<Integer> studentList=new ArrayList<>();
        studentList.add(1);
        studentList.add(6);
        System.out.println(iStudentDao.deleteStudent( studentList,1));
    }
    @Test
    public void loadAllStudent() throws Exception {
        PageHelper.startPage(1,5);
        List<SearchStudentResult> list=iStudentDao.loadAllStudent(1);
        PageInfo pageinfo=new PageInfo(list);
        Page page=(Page)list;
        System.out.println(JSON.toJSONString(page));
    }

    @Test
    public void countStudent(){
        System.out.println(iStudentDao.countStudent(0));
    }
    @Test
    public void searchStudentIDByNo(){
        List<String> studentlist_no=new ArrayList<>();
        studentlist_no.add("12234");
        studentlist_no.add("12235");
        System.out.println(iStudentDao.searchStudentIdByNo(studentlist_no));
    }
}