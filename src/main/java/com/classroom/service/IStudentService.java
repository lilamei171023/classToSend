package com.classroom.service;

import com.classroom.entity.*;
import com.classroom.vo.response.Msg;
import com.classroom.vo.response.People;
import com.classroom.vo.response.SearchStudentResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lilamei
 * @date 2017/11/7 17:10
 */

public interface IStudentService {
    /**
     * 添加一条学生信息
     * @param student
     * @return  消息Msg对象
     */
    Msg register(Student student);

    /**
     * 修改学生个人资料
     * @return 消息Msg对象
     */
    Msg updateStudentInformation(String studentNumber,String studentName,String studentNo,String schoolName);

    /**
     * 修改登录密码
     * @param studentNumber
     * @param studentPwd
     * @return 消息Msg对象
     */
    Msg updatePwd(String studentNumber,String studentPwd);

    public int agreeJoin(@Param("classroom_id") Integer classroom_id, @Param("student_id") Integer student_id);
    public SearchStudentResult selectByNo(@Param("classroom_id") Integer classroom_id, @Param("student_no")  String student_no );
    public List<SearchStudentResult> selectByName(@Param("classroom_id") Integer classroom_id, @Param("student_name") String student_name );
    public Integer searchStudentId(String student_number);
    public int deleteStudent(@Param("student_id") List<Integer> student_id,@Param("classroom_id") Integer classroom_id);
    public String loadAllStudent(int startPage,int classroom_id);
    public int countStudent(int classroom_id);
    public List<Integer>  searchStudentIdByNo(List<String> studentlist_no);
}
