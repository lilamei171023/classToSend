package com.classroom.controller;

import com.classroom.entity.Comment;
import com.classroom.service.ICommentService;
import com.classroom.vo.response.CommentRelevant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author hanmiaomiao
 * @Date 2017/11/06
 * 用户增加评论，删除评论，查找评论
 */

@Controller
@RequestMapping(value="/comment")
public class CommentController {
    @Resource
    private ICommentService iCommentService;

    /**
     * 增加新评论
     * @param session 当前会话
     * @param topicId 前台传入的话题ID
     * @param content 前台传入的话题内容
     * @return
     */
    @RequestMapping(value="/newComment/{topicId}/{content}",method= RequestMethod.POST)
    @ResponseBody
    public boolean newComment(HttpSession session, @PathVariable int topicId, @PathVariable String content){
        Comment comment=new Comment();
        String userLoginNumber=(String)session.getAttribute("userLoginNumber");
        comment.setTopicId(topicId);
        comment.setUserLoginNumber(userLoginNumber);
        comment.setContent(content);
        return iCommentService.insertNewComment(comment);
    }

    /**
     *查找该话题底下所有评论
     * @param topicId 话题ID
     * @return
     */
    @RequestMapping(value="/selectAllComment/{topicId}",method=RequestMethod.POST)
    @ResponseBody
    public List<CommentRelevant> selectAllComment(@PathVariable int topicId){
        return iCommentService.selectCommentByTopicId(topicId);
    }

    /**
     * 删除评论（有删除权限）
     * @param commentId
     * @param userLoginNumber
     * @return
     */
    @RequestMapping(value="/deleteComment/{commentId}/{userLoginNumber}",method=RequestMethod.POST)
    public boolean deleteComment(@PathVariable int commentId,@PathVariable

























            String userLoginNumber){
        return iCommentService.deletedComment(commentId,userLoginNumber);
    }
}