package com.classroom.service;

import com.classroom.entity.Teacher;
import com.classroom.vo.response.Msg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lilamei
 * @date 2017/11/7 17:10
 */


public interface ITeacherService {
    /**
     * 添加一条老师信息
     * @param teacher
     * @return 消息Msg对象
     */
    Msg register(Teacher teacher);

    /**
     * 修改老师基本信息
     * @return 消息Msg对象
     */
    Msg updateTeacherInformation(String teacherNumber,String teacherName,String teacherNo,String schoolName);

    /**
     * 修改老师登录密码
     * @param teacherNumber
     * @param teacherPwd
     * @return 消息Msg对象
     */
    Msg updatePwd(String teacherNumber,String teacherPwd);

    public int teacherJion(@Param("classroom_id") Integer  classroom_id, @Param("teacher_id") Integer teacher_id);
    public List<Teacher> searchTeacherName(int classroom_id);
    public Integer searchTeacherId(String teacher_number);
    public List<String> checkClassroom(String teacher_number);
}
