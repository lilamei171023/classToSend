package com.classroom.dao;

import com.classroom.BaseTest;
import com.classroom.entity.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

public class ITopicDaoTest extends BaseTest{

    @Autowired
    private ITopicDao topicDao;
    @Test
    public void selectUserTopic() throws Exception {
        System.out.println("mmmmmmmmmmmmmm    "+topicDao.selectUserTopic("1"));
    }

    @Test
    public void selectKeywordTopic() throws Exception {
        System.out.println("mmmmmmmmmmmmmm    "+topicDao.selectKeywordTopic("英语"));

    }

    @Test
    public void selectOneClassTopic() throws Exception {
    }

    @Test
    public void selectAllTopic() throws Exception {
        System.out.println("mmmmmmmmm"+topicDao.selectAllTopic());
    }

    @Test
    public void agreeTopic() throws Exception {
        System.out.println("mmmmmmmmmm"+topicDao.agreeTopic(2));
    }

    @Test
    public void scanTimes() throws Exception {
        System.out.println("mmmmmmmm");
    }

    @Test
    public void deletedTopic() throws Exception {
        System.out.println("mmmmmmmmmm"+topicDao.deletedTopic(2));
    }



    @Test
    public void insertNewTopic() throws Exception{
        Topic topic=new Topic();
        topic.setTopicTitle("这英语道题怎么做bbbb");
        topic.setTopicContent("求老师指教");
        topic.setUserLoginNumber("2");
        System.out.println("mmmmmmmmmmmmmm    "+topicDao.insertNewTopic(topic));

    }

}