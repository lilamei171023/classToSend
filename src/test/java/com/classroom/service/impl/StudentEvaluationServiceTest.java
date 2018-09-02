package com.classroom.service.impl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class StudentEvaluationServiceTest{
    @Autowired
    private StudentEvaluationService studentEvaluationService ;
    @Test
    public void showEvaluation() throws Exception {
        System.out.println( studentEvaluationService.showEvaluation(1));
    }
}

