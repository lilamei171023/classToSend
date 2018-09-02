package com.classroom.service.impl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class CreateServiceTest{
    @Autowired
    private CreateClassService createClassService;
    @Test
    public void createClassTest() throws Exception {
        System.out.println(createClassService.createClass("概率论与数理统计","sjvddd"));
    }

}
