package com.classroom.service.impl;

import com.classroom.dao.ICommentDao;
import com.classroom.dao.ITopicDao;
import com.classroom.entity.Comment;
import com.classroom.vo.response.CommentRelevant;
import com.classroom.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentDao iCommentDao;
    @Autowired
    private ITopicDao iTopicDao;

    public CommentServiceImpl() {
    }
    public CommentServiceImpl(ICommentDao iCommentDao,ITopicDao iTopicDao) {
        this.iCommentDao=iCommentDao;
        this.iTopicDao=iTopicDao;
    }
    public boolean insertNewComment(Comment comment){
        iTopicDao.commentsTimesAdd(comment.getTopicId());
        return iCommentDao.insertNewComment(comment);
    }
    public List<CommentRelevant> selectCommentByTopicId(int topicId){
        return iCommentDao.selectCommentByTopicId(topicId);
    }

    @Override
    public boolean deletedComment(int commentId, String useLoginNumber) {
        return iCommentDao.deleteComment(commentId,useLoginNumber);
    }

    @Override
    public boolean agreeComment(int commentId) {
        return iCommentDao.agreeComment(commentId);
    }
}
