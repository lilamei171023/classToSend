package com.classroom.service.impl;

import com.classroom.dao.ITopicDao;
import com.classroom.entity.Topic;
import com.classroom.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.classroom.vo.response.TopicRelevant;

import java.util.List;

@Service
public class TopicServiceImpl implements ITopicService {
    private ITopicDao topicDao;
    @Autowired
    public TopicServiceImpl(ITopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Override
    public boolean newTopic(Topic topic) {

        return topicDao.insertNewTopic(topic);
    }

    @Override
    public List<TopicRelevant> selectUserTopic(String userLoginNumber) {
        return topicDao.selectUserTopic(userLoginNumber);
    }

    @Override
    public List<TopicRelevant> selectKeywordTopic(String keyword) {
        return topicDao.selectKeywordTopic(keyword);
    }



    @Override
    public List<TopicRelevant> selectOneClassTopic() {
        return null;
    }



    @Override
    public List<TopicRelevant> selectAllTopic() {
        return topicDao.selectAllTopic();
    }

    @Override
    public Boolean agreeTopic(int topicId) {
        return topicDao.agreeTopic(topicId);
    }

    @Override
    public void scanTimes(int topicId) {
         topicDao.scanTimes(topicId);
    }

    @Override
    public boolean deletedTopic(int topicId) {
        return topicDao.deletedTopic(topicId);
    }
}
