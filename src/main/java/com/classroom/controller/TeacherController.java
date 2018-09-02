package com.classroom.controller;
import com.classroom.entity.Teacher;
import com.classroom.service.ICreateClassService;
import com.classroom.service.ITeacherService;
import com.classroom.vo.response.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author  Lilamei
 * @date 2017/11/6 16:20
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private ITeacherService iTeacherService;
    @Resource
    private ICreateClassService iCreateClassService;

    /**
     * 老师注册
     * @param teacher
     * @return 消息Msg对象
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Msg register(Teacher teacher){
        return iTeacherService.register(teacher);
    }


   /*
    * 老师加入班级
    * @param invitation_code 前台传入的邀请码
    * @param teacher_number  前台传入的学生的登录账号
    * @return
    * */

    @RequestMapping(value="/teacherJion",method=RequestMethod.POST)
    @ResponseBody
    public int teacherJion(HttpSession session,String invitation_code){
        int classroom_id=iCreateClassService.searchClassroomId(invitation_code);
        int teacher_id=iTeacherService.searchTeacherId((String)session.getAttribute("userloginNumber"));
        return iTeacherService.teacherJion(classroom_id,teacher_id);
    }
    /*
    * 在前台显示一个班级的所有老师
    * @param invitation_code 前台传入的邀请码
    * @return
    * */


    @RequestMapping(value="/searchTeacherName",method=RequestMethod.POST)
    @ResponseBody
    public List<Teacher> searchTeacherName(String invitation_code){
        return iTeacherService.searchTeacherName(iCreateClassService.searchClassroomId(invitation_code));
    }
    /*
    * 在前台显示一个老师加入过的所有班级
    * @param session 一次会话
    * @param teacher_number 教师的登录账号
    * @return
    * */

    @RequestMapping(value="/checkClassroom",method=RequestMethod.POST)
    @ResponseBody
    public List<String> checkClassroom(HttpSession session){
        return iTeacherService.checkClassroom(session.getAttribute("userloginNumber").toString());
    }

}

