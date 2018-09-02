package com.classroom.dao;

import com.classroom.entity.Homework;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class IHomeworkDaoTest {
    @Autowired
    private IHomeworkDao iHomeworkDao;

    @Test
    public void downloadAllHomework() throws Exception {
        iHomeworkDao.DownloadAllHomework(1);
    }

    @Test
    public void downloadHomeworkByName() throws Exception {
        iHomeworkDao.DownloadHomeworkByName("高数习题1",1);
    }

    @Test
    public void downloadHomeworkByType() throws Exception {
        iHomeworkDao.DownloadHomeworkByType("高数",1);
    }

    @Test
    public void downloadHomeworkByNumber() throws Exception {
        iHomeworkDao.DownloadHomeworkByNumber("0011",1);
    }

    @Test
    public void downloadHomework() throws Exception {
        iHomeworkDao.DownloadHomework("高数习题2");
    }
    @Test
    public void insertHomework() throws Exception {
        Homework homework=new Homework();
        homework.setStudentNumber("1");
        homework.setClassroomId(1);
        homework.setHomeworkPath("2");
        homework.setHomeworkType("2");
        homework.setHomeworkName("2");
        iHomeworkDao.insertHomework(homework);
    }
    @Test
    public void updateHomework()throws Exception{
        iHomeworkDao.updateHomework("44","2");
    }

    @Test
    public void deleteHomework() throws Exception {
        iHomeworkDao.deleteHomework("2");
    }

}