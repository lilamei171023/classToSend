package com.classroom.service;
import com.classroom.vo.response.CommentRelevant;
import com.classroom.entity.Comment;

import java.util.List;

/**
 * @Author hanmiaomiao
 * @Date 2017/11/05
 */
public interface ICommentService {
    /***
     *通过传入的comment对象，将comment相关数据加入到数据库中
     *
     * @param comment 评论对象
     * @return
     */
    public boolean insertNewComment(Comment comment);

    /**
     * 查找一条话题底下的所有评论
     * @param topicId
     * @return
     */
    public List<CommentRelevant> selectCommentByTopicId(int topicId);

    /**
     * 删除评论 （删除权限）
     * @param commentId
     * @param useLoginNumber
     * @return
     */
    public boolean deletedComment(int commentId, String useLoginNumber);

    /**
     * 点赞
     * @param commentId
     * @return
     */
    public boolean agreeComment(int commentId);
}
