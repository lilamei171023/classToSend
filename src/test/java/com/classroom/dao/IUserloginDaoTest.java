package com.classroom.dao;

import com.classroom.BaseTest;
import com.classroom.entity.Userlogin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * @author LiLaMei
 * @date 2017/11/3
 */

public class IUserloginDaoTest extends BaseTest{

   @Autowired
    private  IUserloginDao iUserloginDao;

    @Test
    public void testCheckLogin() throws Exception {
     System.out.println( iUserloginDao.checkLogin("150700304","abcdefgh"));

    }

    @Test
    public void getById() throws Exception {
        Userlogin userlogin;
        userlogin=iUserloginDao.getById(8);
        System.out.println(userlogin.toString());
    }

    @Test
    public void addUserlogin() throws Exception {
     Userlogin userlogin=new Userlogin();
     userlogin.setUserloginNumber("a1111");
     userlogin.setUserloginPwd("aaaaaaaa");
     userlogin.setTarget("1");
     Integer test1;
      test1=iUserloginDao.addUserlogin(userlogin);
      System.out.println(test1.toString());
    }

    @Test
    public void updatePwd() throws Exception {
       Integer test1;
        test1=iUserloginDao.updatePwd("a1111","11111111");
        System.out.println(test1.toString());
    }
}