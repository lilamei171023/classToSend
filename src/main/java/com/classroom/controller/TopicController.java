package com.classroom.controller;

import com.classroom.entity.Topic;
import com.classroom.service.ICommentService;
import com.classroom.service.ITopicService;
import com.classroom.vo.response.TopicRelevant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *@Author hanmiaomiao
 *@Date 2017/11/5
 */
@Controller
@RequestMapping(value="/topic")
public class TopicController {
    private Logger logger= LoggerFactory.getLogger(TopicController.class);

    @Resource
    private ITopicService iTopicService;
    @Resource
    private ICommentService iCommentService;

    /**
     * 新建话题
     * @param session 当前用户会话
     * @param topicTitle 话题标题
     * @param content 话题内容
     */
      @RequestMapping(value="/newTopic",method= RequestMethod.POST)
      public boolean newTopic(HttpSession session, String topicTitle, String content){
          String userLoginNumber=(String)session.getAttribute("userLoginNumber");
          Topic topic=new Topic();
          topic.setUserLoginNumber(userLoginNumber);
          topic.setTopicTitle(topicTitle);
          topic.setTopicContent(content);

          return  iTopicService.newTopic(topic);

      }

    /**
     * 根据类型查找话题
     * @param topicTarget 标志
     * @param userLoginNumber 该用户的id查找他发布的所有话题
     * @param topicKeyword 要查找的关键字
     * @return
     */
      @RequestMapping(value="/selectTopic/{topicTarget}/{userLoginNumber}/{topicKeyword}",method=RequestMethod.POST)
      public List<TopicRelevant> selectTopic(@PathVariable int topicTarget, @PathVariable String userLoginNumber, @PathVariable String topicKeyword){
          List<TopicRelevant> topics=null;

          switch(topicTarget){
              case 1:topics=iTopicService.selectOneClassTopic(); break;
              case 2:topics=iTopicService.selectAllTopic();break;
              case 3:topics=iTopicService.selectKeywordTopic(topicKeyword);break;
              case 4:topics=iTopicService.selectUserTopic(userLoginNumber);break;
          }

          return topics;
      }

    /**
     * 话题或者评论点赞
     * @param id 话题或者评论的ID
     * @param agreeTarget 标志
     * @return
     */
      @RequestMapping (value="/agree/{id}/{agreeTarget}",method=RequestMethod.POST)
      public boolean agree(@PathVariable int id,@PathVariable int agreeTarget){
          boolean bool;
          if(agreeTarget==0){
              bool=iCommentService.agreeComment(id);
          }else {
              bool=iTopicService.agreeTopic(id);
          }
          return bool;
      }

    /**
     * 话题浏览次数+1
     * @param topicId
     */
      @RequestMapping(value="/scanTimes/{topicId}",method=RequestMethod.POST)
      public void scanTimes(@PathVariable int topicId){
          iTopicService.scanTimes(topicId);
      }

    /**
     * 删除话题
     * @param topicId
     * @return
     */
      @RequestMapping(value="/deleteTopic/{topicId}",method =RequestMethod.POST)
      public  boolean deleteTopic(@PathVariable int topicId ){
          return iTopicService.deletedTopic(topicId);
      }
}
