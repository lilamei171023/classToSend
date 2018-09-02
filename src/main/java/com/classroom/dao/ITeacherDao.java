package com.classroom.dao;
import com.classroom.entity.Teacher;
import com.classroom.vo.response.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lilamei
 * @date 2017/11/2 20:55
 */
@Mapper
@Repository
public interface ITeacherDao {
    /**
     * 添加一个老师到teacher表中
     */
    Integer register(Teacher teacher);
    /**
     * teacher表中查询登录用户信息
     */
    People checkShortMessage(String teacherNumber);
    /**
     * 修改老师资料
     */
    Integer update(@Param("teacherNumber") String teacherNumber,
                   @Param("teacherName") String teacherName,
                   @Param("teacherNo") String teacherNo,
                   @Param("schoolName") String schoolName);
    /**
     * 修改老师密码
     */
    Integer updatePwd(@Param("teacherNumber") String teacherNumber,
                      @Param("teacherPwd") String teacherPwd);

    public int teacherJion(@Param("classroom_id") Integer  classroom_id,@Param("teacher_id") Integer teacher_id);
    public List<Teacher> searchTeacherName(Integer  classroom_id);
    public Integer searchTeacherId(String teacher_number);
    public List<String> checkClassroom(String teacher_number);
}
