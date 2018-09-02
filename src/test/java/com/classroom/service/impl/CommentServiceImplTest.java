package com.classroom.service.impl;

import com.classroom.entity.Comment;
import com.classroom.service.ICommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class CommentServiceImplTest {



    @Autowired
    private ICommentService iCommentService;
    @Test
    public void insertNewComment() throws Exception {
        Comment comment=new Comment();
        comment.setContent("这很简单");
        comment.setUserLoginNumber("1");
        comment.setTopicId(1);
        System.out.println("service    "+iCommentService.insertNewComment(comment));
    }
    @Test
    public void selectCommentByTopicId() throws Exception {
        System.out.println(iCommentService.selectCommentByTopicId(1)+"/n");

    }
    @Test
    public void deletedComment() throws Exception {
        System.out.println(iCommentService.deletedComment(1,"1"));
    }

    @Test
    public void agreeComment() throws Exception {
        System.out.println(iCommentService.agreeComment(1));
    }
}







