package com.classroom.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class ICreateClassTest {
    @Autowired
    private ICreateClassDao iCreateClassDao;
    @Test
    public void createClassTest() throws Exception {
        System.out.println(iCreateClassDao.createClass("通信原理1","nbbxbs"));
    }
   @Test
    public void searchClassroomId() throws Exception{
        System.out.println(iCreateClassDao.searchClassroomId("nbbxbs"));
    }
}

