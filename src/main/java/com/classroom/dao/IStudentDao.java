package com.classroom.dao;


import com.classroom.entity.*;
import com.classroom.vo.response.People;
import com.classroom.vo.response.SearchStudentResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LiLaMei
 * @date 2017/11/2 20:55
 */

@Mapper
@Repository
public interface IStudentDao {
    /**
     * 添加一个学生到student表中
     */
    Integer register(Student student);
    /**
     * 在student表中查询登录用户信息
     */
    People checkShortMessage(String studentNumber);
    /**
     * 修改学生信息
     */
    Integer update(@Param("studentNumber") String studentNumber,
                   @Param("studentName") String studentName,
                   @Param("studentNo") String studentNo,
                   @Param("schoolName") String schoolName);
    /**
     * 修改登录密码
     */
    Integer updatePwd (@Param("studentNumber") String studentNumber,
                       @Param("studentPwd") String studentPwd);


    public int agreeJoin(@Param("classroom_id") Integer classroom_id, @Param("student_id") Integer student_id);
    public SearchStudentResult selectByNo(@Param("student_no")  String student_no, @Param("classroom_id") Integer classroom_id);
    public List<SearchStudentResult> selectByName(@Param("student_name") String student_name,@Param("classroom_id") Integer classroom_id);
    public Integer searchStudentId(String student_number);
    public int deleteStudent(@Param("student_id") List<Integer> student_id,@Param("classroom_id") Integer classroom_id);
    public List<SearchStudentResult> loadAllStudent(int classroom_id);
    public int countStudent(int classroom_id);
    public List<Integer>  searchStudentIdByNo(List<String> studentlist_no);


}
