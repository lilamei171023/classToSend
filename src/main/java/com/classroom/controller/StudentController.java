package com.classroom.controller;


import com.classroom.entity.*;
import com.classroom.service.ICreateClassService;
import com.classroom.service.IStudentService;
import com.classroom.vo.response.Msg;
import com.classroom.vo.response.SearchStudentResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author  Lilamei
 * @Date 2017/11/6 16:05
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private IStudentService iStudentService;
    @Resource
    private ICreateClassService iCreateClassService;

    /**
     * 学生注册
     * @param student
     * @return Msg对象
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Msg register(Student student){
        return iStudentService.register(student);
    }



   /*
    * 学生加入班级
    * @param session
    * @param invitation_code  前台传入的邀请码
    * @param student_number   前台传入的学生的登录账号
    * @return
    *
    * */

    @RequestMapping(value = "/agreeJoin", method = RequestMethod.POST)
    @ResponseBody
    public int agreeJoin(HttpSession session, String invitation_code) {
        int classroom_id = iCreateClassService.searchClassroomId(invitation_code);
        String student_number = (String) session.getAttribute("userlogin_number");
        int student_id = iStudentService.searchStudentId(student_number);
        return iStudentService.agreeJoin(student_id, classroom_id);
    }


   /*
     * 删除学生
     * @param student_no 学生的学工号
     * @param classroom_id 班级id
     * @return
     */

    @RequestMapping(value="/deleteStudent",method=RequestMethod.POST)
    @ResponseBody
    public int deleteStudent(List<String> student_no,Integer classroom_id){
        List<Integer> studentNo=iStudentService.searchStudentIdByNo(student_no);
        return iStudentService.deleteStudent(studentNo,classroom_id);
    }

    /*
     * 按学生的学工号查询
     * @param student_no 学生的学工号
     * @param classroom_id 班级id
     * @return
     */

    @RequestMapping(value="/selectByNo",method=RequestMethod.POST)
    @ResponseBody
    public SearchStudentResult selectByNo(String student_no, Integer classroom_id ){
        return  iStudentService.selectByNo(classroom_id,student_no);
    }

    /*
     * 按学生的学工号查询
     * @param student_name 学生的姓名
     * @param classroom_id 班级id
     * @return
     */

    @RequestMapping(value="/selectByName",method=RequestMethod.POST)
    @ResponseBody
    public List<SearchStudentResult> selectByName(String student_name,Integer classroom_id ){
        return iStudentService.selectByName(classroom_id,student_name);
    }

    /*
     * 在页面上显示所有的学生
     * @param startPage
     * @param classroom_id 班级id
     * @return
     */

    @RequestMapping(value="/loadAll",method=RequestMethod.POST)
    @ResponseBody
    public String loadAll(Integer startPage, Integer classroom_id){
        return  iStudentService.loadAllStudent(startPage,classroom_id);
    }

    /*
     * 在页面上显示一个班的班级成员
     * @param classroom_id 班级id
     * @return
     */

    @RequestMapping(value="/countStudent",method=RequestMethod.POST)
    @ResponseBody
    public int countStudent(Integer classroom_id){
        return   iStudentService.countStudent(classroom_id);
    }
}
