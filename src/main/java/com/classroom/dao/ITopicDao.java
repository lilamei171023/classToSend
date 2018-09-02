package com.classroom.dao;


import com.classroom.entity.Topic;
import com.classroom.vo.response.TopicRelevant;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author hanmiaomiao
 * @Date 2017/11/05
 */
@Repository
public interface ITopicDao {
    /**
     * 在数据库添加一条话题
     * @param topic
     * @return
     */

    public  boolean insertNewTopic(Topic topic);

    /**
     * 该用户的所有提问
     * @param userLoginNumber 用户的登录账号
     * @return
     */
    public List<TopicRelevant> selectUserTopic(String userLoginNumber);

    /**
     * 按关键字查找有提问
     * @param keyword
     * @return
     */
    public List<TopicRelevant> selectKeywordTopic(String keyword);

    /**
     * 该用户所在班级的所有提问
     * @return
     */
    public List<TopicRelevant> selectOneClassTopic();

    /**
     * 所有提问
     * @return
     */
    public List<TopicRelevant> selectAllTopic();

    /**
     * 话题点赞次数+1
     * @param topicId
     * @return
     */
    public Boolean agreeTopic(int topicId);

    /**
     * 话题评论次数+1
     * @param topicId
     */
    public void commentsTimesAdd(int topicId);
    /**
     * 话题浏览次数+1
     * @param topicId
     * @return
     */
    public void scanTimes(int topicId);

    /**
     * 删除话题以及话题底下所有评论
     * @param topicId
     * @return
     */
    public boolean deletedTopic(int topicId);

}
