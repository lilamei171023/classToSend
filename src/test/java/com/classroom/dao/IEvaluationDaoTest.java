package com.classroom.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})

public class IEvaluationDaoTest {
    @Autowired
    private com.classroom.dao.IEvaluationDao iEvaluationDao;
    @Test
    public void updateEvaluation() throws Exception {
        iEvaluationDao.updateHomeworkSum(1,1);
    }
    @Test
    public  void updateHomeworkCount()throws Exception{
        iEvaluationDao.updateHomeworkCount(1,"1");
    }
    @Test
    public void selectHomeworkSum()throws Exception{
        System.out.println(iEvaluationDao.selectHomeworkSum(1));
    };
    @Test
    public void selectHomeworkCount()throws Exception{
        System.out.println(iEvaluationDao.selectHomeworkCount("100001"));
    }

}