package com.classroom.controller;

import com.classroom.service.ICreateClassService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/Class")
public class CreateClassController {
    @Resource
    private ICreateClassService createClassService;
    /*
    * 创建班级
    * @param invitation_code 前台传入的班级邀请码
    * @param classroom_name 前台传入的班级名称
    */

    @RequestMapping(value="/createClass",method= RequestMethod.POST)
    @ResponseBody
    public int createClass(String invitationCode, String classroomName){
        return createClassService.createClass(classroomName,invitationCode);
    }
    /*
    * 创建班级完成后给前端传送班级id以作备用
    *  @param invitation_code 前台传入的班级邀请码
    */

    @RequestMapping(value="/searchClassroomId",method= RequestMethod.POST)
    @ResponseBody
    public  int searchClassroomId(String invitation_code){
        return createClassService.searchClassroomId(invitation_code);
    }
}
