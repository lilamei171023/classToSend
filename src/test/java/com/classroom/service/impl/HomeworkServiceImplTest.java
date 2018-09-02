package com.classroom.service.impl;

import com.classroom.entity.Homework;
import com.classroom.service.IHomeworkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class HomeworkServiceImplTest {
    @Autowired
    private IHomeworkService iHomeworkService;
    @Test
    public void downloadAllHomework() throws Exception {
        iHomeworkService.DownloadAllHomework(1);
    }

    @Test
    public void downloadHomeworkByName() throws Exception {
        iHomeworkService.DownloadHomeworkByName("高数习题1",1);
    }

    @Test
    public void downloadHomeworkByType() throws Exception {
        iHomeworkService.DownloadHomeworkByType("高数",1);
    }

    @Test
    public void downloadHomeworkByNumber() throws Exception {
        iHomeworkService.DownloadHomeworkByNumber("0011",1);
    }

    @Test
    public void downloadHomework() throws Exception {
        iHomeworkService.DownloadHomework("高数习题2");
    }


    @Test
    public void insertHomework() throws Exception {
        Homework homework=new Homework();
        homework.setStudentNumber("1");
        homework.setClassroomId(1);
        homework.setHomeworkPath("2");
        homework.setHomeworkType("2");
        homework.setHomeworkName("2");
        iHomeworkService.insertHomework(homework);
    }

    @Test
    public void deleteHomework() throws Exception {
        iHomeworkService.deleteHomework("2");
    }

}