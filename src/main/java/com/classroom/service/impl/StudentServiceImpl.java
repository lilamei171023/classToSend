package com.classroom.service.impl;

import com.alibaba.fastjson.JSON;
import com.classroom.dao.IStudentDao;
import com.classroom.dao.IUserloginDao;
import com.classroom.entity.*;
import com.classroom.service.IStudentService;
import com.classroom.util.MD5Util;
import com.classroom.vo.response.Msg;
import com.classroom.vo.response.People;
import com.classroom.vo.response.SearchStudentResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiLaMei
 * @Date 2017/11/7 17:10
 */

@Service("studentService")
public class StudentServiceImpl implements IStudentService {


    private final IStudentDao   iStudentDao;
    private final IUserloginDao iUserloginDao;

    public StudentServiceImpl(IStudentDao iStudentDao, IUserloginDao iUserloginDao) {
        this.iStudentDao = iStudentDao;
        this.iUserloginDao = iUserloginDao;
    }

    /**
     * 学生注册
     * @param student
     * @return
     */
    @Override
    public Msg register(Student student) {

        Userlogin userlogin=new Userlogin();
        userlogin.setUserloginNumber(student.getStudentNumber());
        //二次加密，加盐
        String code= MD5Util.generate(student.getStudentPwd(), student.getStudentNumber());
        userlogin.setUserloginPwd(code);

        // 在userlogin表中标识用户身份为学生
        userlogin.setTarget("1");
        student.setStudentPwd(code);
        //第一次注册系统默认分配头像
        student.setStudentPhoto("photo");
        Integer integer1=iUserloginDao.addUserlogin(userlogin);
        Integer integer=iStudentDao.register(student);

        if(integer!=0&&integer1!=0){
            return   Msg.success();
        }
          else return  Msg.fail();

    }



    /**
     * 修改学生个人信息
     * @param studentNumber
     * @param studentName
     * @param studentNo
     * @param schoolName
     * @return
     */
    @Override
    public Msg updateStudentInformation(String studentNumber,String studentName,String studentNo,String schoolName) {
       Integer integer=iStudentDao.update(studentNumber,studentName,studentNo,schoolName);
       if (integer==1){
           return  Msg.success();
       }else
        return Msg.fail();
    }

    /**
     * 修改学生账号密码
     * @param studentNumber
     * @param studentPwd
     * @return
     */
    @Override
    public Msg updatePwd(String studentNumber,String studentPwd) {
       //二次加密
        String code= MD5Util.generate(studentPwd, studentNumber);
        Integer integer=iStudentDao.updatePwd(studentNumber,code);
        Integer integer1=iUserloginDao.updatePwd(studentNumber,code);
        if (integer==1&&integer1==1){
            return  Msg.success();
        }else
            return Msg.fail();
    }


    public int agreeJoin(@Param("classroom_id") Integer classroom_id, @Param("student_id") Integer student_id){
        return  iStudentDao.agreeJoin(classroom_id,student_id);
    }
    public SearchStudentResult selectByNo(@Param("classroom_id") Integer classroom_id, @Param("student_no")  String student_no ){
        return   iStudentDao.selectByNo(student_no,classroom_id);
    }
    public List<SearchStudentResult> selectByName(@Param("classroom_id") Integer classroom_id, @Param("student_name") String student_name ){
        return   iStudentDao.selectByName(student_name,classroom_id);
    }
    public Integer searchStudentId(String student_number){
        return   iStudentDao.searchStudentId(student_number);
    }
    public int deleteStudent(@Param("student_id") List<Integer> student_id,@Param("classroom_id") Integer classroom_id){
        return   iStudentDao.deleteStudent(student_id,classroom_id);
    }
    public String  loadAllStudent(int startPage,int classroom_id){
        PageHelper.startPage(startPage,5);
        List<SearchStudentResult> list= iStudentDao.loadAllStudent(classroom_id);
        PageInfo pageinfo=new PageInfo(list);
        Page page=(Page)list;
        return (JSON.toJSONString(page));
    }
    public int countStudent(int classroom_id){
        return   iStudentDao.countStudent(classroom_id);
    }
    public List<Integer>  searchStudentIdByNo(List<String> studentlist_no){
        return   iStudentDao.searchStudentIdByNo(studentlist_no);
    }

}
