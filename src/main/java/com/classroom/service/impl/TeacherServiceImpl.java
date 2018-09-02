package com.classroom.service.impl;

import com.classroom.dao.ITeacherDao;
import com.classroom.dao.IUserloginDao;
import com.classroom.entity.Teacher;
import com.classroom.entity.Userlogin;
import com.classroom.service.ITeacherService;
import com.classroom.util.MD5Util;
import com.classroom.vo.response.Msg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lilamei
 * @date 2017/11/7 17:10
 */

@Service("teacherService")
public class TeacherServiceImpl implements ITeacherService {

    private final IUserloginDao iUserloginDao;
    private final ITeacherDao iTeacherDao;

    public TeacherServiceImpl(IUserloginDao iUserloginDao, ITeacherDao iTeacherDao) {
        this.iUserloginDao = iUserloginDao;
        this.iTeacherDao = iTeacherDao;
    }

    /**
     * 老师注册
     * @param teacher
     * @return
     */
    @Override
    public Msg register (Teacher teacher) {
        Userlogin userlogin=new Userlogin();
        userlogin.setUserloginNumber(teacher.getTeacherNumber());
        //二次加密，加盐
        String code= MD5Util.generate(teacher.getTeacherPwd(), teacher.getTeacherNumber());
        userlogin.setUserloginPwd(code);

        // 在userlogin表中设target=0即身份是老师
        userlogin.setTarget("0");
        teacher.setTeacherPwd(code);

        //第一次注册系统默认分配头像
        teacher.setTeacherPhoto("photo");
        Integer integer1=iUserloginDao.addUserlogin(userlogin);
        Integer integer=iTeacherDao.register(teacher);

        if(integer!=0&&integer1!=0){

            return   Msg.success();
        }
        else return Msg.fail();

    }

    /**
     * 修改老师个人信息
     * @param teacherNumber
     * @param teacherName
     * @param teacherNo
     * @param schoolName
     * @return
     */
    @Override
    public Msg updateTeacherInformation(String teacherNumber,String teacherName,String teacherNo,String schoolName) {
        Integer integer=iTeacherDao.update(teacherNumber,teacherName,teacherNo,schoolName);
        if (integer==1){
            return  Msg.success();
        }else
            return Msg.fail();
    }

    /**
     * 修改老师账号密码
     * @param teacherNumber
     * @param teacherPwd
     * @return
     */
    @Override
    public Msg updatePwd(String teacherNumber,String teacherPwd) {

        //二次加密，加盐
        String code= MD5Util.generate(teacherPwd, teacherNumber);
        Integer integer=iTeacherDao.updatePwd(teacherNumber,code);
        Integer integer1=iUserloginDao.updatePwd(teacherNumber,code);
        if (integer==1&&integer1==1){
            return  Msg.success();
        }else
            return Msg.fail();
    }

    public int teacherJion(@Param("classroom_id") Integer  classroom_id, @Param("teacher_id") Integer teacher_id){
        return  iTeacherDao.teacherJion(classroom_id,teacher_id);
    }
    public List<Teacher> searchTeacherName(int classroom_id){
        return   iTeacherDao.searchTeacherName(classroom_id);
    }
    public Integer searchTeacherId(String teacher_number){
        return   iTeacherDao.searchTeacherId(teacher_number);
    }
    public List<String> checkClassroom(String teacher_number){
        return  iTeacherDao.checkClassroom(teacher_number);
    }

}

