package com.classroom.dao;

import com.classroom.BaseTest;
import com.classroom.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

public class ICommentDaoTest extends BaseTest{



    @Autowired
    private ICommentDao iCommentDao;
    @Test
    public void insertNewComment(){
        Comment comment=new Comment();
        comment.setContent("这很简单");
        comment.setUserLoginNumber("2");
        comment.setTopicId(1);
        System.out.println("mmmmmmmmm    "+iCommentDao.insertNewComment(comment));
    }
    @Test
    public void selectCommentByTopicId() throws Exception {
        System.out.println(iCommentDao.selectCommentByTopicId(1));
    }
    @Test
    public void deleteComment() throws Exception {
        System.out.println(iCommentDao.deleteComment(2,"2"));
    }
    @Test
    public void agreeComment() throws Exception {
        System.out.println(iCommentDao.agreeComment(2));
    }
}