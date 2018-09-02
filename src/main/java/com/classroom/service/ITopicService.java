package com.classroom.service;

import com.classroom.entity.Topic;
import com.classroom.vo.response.TopicRelevant;

import java.util.List;

/**
 * @Author hanmiaomiao
 * @Date 2017/11/05
 */
public interface ITopicService {
    /**
     *通过传入的topic对象，将topic相关属性加入到数据库中
     *
     * @param topic
     * @return
     */
    public boolean newTopic(Topic topic);
    public List<TopicRelevant> selectUserTopic(String userLoginNumber);
    public List<TopicRelevant> selectKeywordTopic(String keyword);
    public List<TopicRelevant> selectOneClassTopic();
    public List<TopicRelevant> selectAllTopic();
    public Boolean agreeTopic(int topicId);
    public void scanTimes(int topicId);
    public boolean deletedTopic(int topicId);

}
