package com.classroom.service.impl;

import com.classroom.entity.Topic;
import com.classroom.service.ITopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class TopicServiceImplTest {



    @Autowired
    private ITopicService iTopicService;
    @Test
    public void testNewTopic(){
        Topic topic=new Topic();
        topic.setTopicTitle("这英语道题怎么做aaa");
        topic.setTopicContent("求老师指教");
        topic.setUserLoginNumber("2");

        System.out.println(iTopicService.newTopic(topic));
        System.out.println(topic.getTopicId());
    }


    @Test
    public void selectUserTopic() throws Exception {
        System.out.println(iTopicService.selectUserTopic("2"));
    }

    @Test
    public void selectKeywordTopic() throws Exception {
        System.out.println(iTopicService.selectKeywordTopic("老师"));
    }

    @Test
    public void selectOneClassTopic() throws Exception {
    }

    @Test
    public void selectAllTopic() throws Exception {
        System.out.println(iTopicService.selectAllTopic());
    }

    @Test
    public void agreeTopic() throws Exception {
        System.out.println(iTopicService.agreeTopic(1));
    }

    @Test
    public void scanTimes() throws Exception {
        System.out.println("mm");
    }

    @Test
    public void deletedTopic() throws Exception {
        System.out.println(iTopicService.deletedTopic(1));
    }
}