package com.classroom.dao;

import com.classroom.entity.Comment;
import com.classroom.vo.response.CommentRelevant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentDao {
    /**
     * 新添加一条评论
     * @param comment
     * @return
     */
    public boolean insertNewComment(Comment comment);

    /**
     * 查询一条话题底下的所有评论
     * @param topicId
     * @return
     */
    public List<CommentRelevant> selectCommentByTopicId(int topicId);

    /**
     * 删除一条评论
     * @param commentId
     * @return
     */
    public boolean deleteComment(@Param("commentId") int commentId, @Param("userLoginNumber") String userLoginNumber);

    /**
     * 给一条评论的点赞次数加一
     * @param commentId
     * @return
     */
    public boolean agreeComment(int commentId);
}
