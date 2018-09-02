package com.classroom.service.impl;

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

public class UserloginServiceImplTest extends BaseTest {
    @Autowired
    private UserloginServiceImpl userloginService;

    @Test
    public void checkLoginTest() throws Exception { System.out.println(userloginService.checkLogin("1234567890", "a1234567890"));

    }

    @Test
    public void getByIdTest() throws Exception {
       Userlogin userlogin;
       userlogin=userloginService.getById(8);
       System.out.println(userlogin.toString());
    }

//    @Test
//    public void showShortMessageTest() throws Exception {
//
////        System.out.println(userloginService.showShortMessage());
//    }
}