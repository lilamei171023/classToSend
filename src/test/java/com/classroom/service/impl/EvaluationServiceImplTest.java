package com.classroom.service.impl;

import com.classroom.service.IEvaluationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class EvaluationServiceImplTest {
    @Autowired
    private IEvaluationService iEvaluationService;
    @Test
    public void updateEvaluation() throws Exception {
        iEvaluationService.updateHomeworkSum(1,1);
    }
    @Test
    public  void updateHomeworkCount()throws Exception{
        iEvaluationService.updateHomeworkCount(2,"1");
    }
    @Test
    public void selectHomeworkSum()throws Exception{
       System.out.println(iEvaluationService.selectHomeworkSum(1));
    }
    @Test
    public void selectHomeworkCount()throws Exception{
        System.out.println(iEvaluationService.selectHomeworkCount("100001"));

    }

}