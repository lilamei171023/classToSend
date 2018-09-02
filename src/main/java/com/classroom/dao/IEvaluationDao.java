package com.classroom.dao;

import org.apache.ibatis.annotations.Param;

public interface IEvaluationDao {
    /**
     * 更新老师布置作业总次数
     * @param homeworkSum 老师布置作业总次数
     * @param classroomId 班级id
     * @return
     */
    public void updateHomeworkSum(@Param("homeworkSum") int homeworkSum, @Param("classroomId") int classroomId);
    /**
     * 更新学生上交作业总次数
     * @param homeworkCount 学生上交数据总次数
     * @param studentNumber 学生账号
     * @return
     */
    public void updateHomeworkCount(@Param("homeworkCount") int homeworkCount, @Param("studentNumber") String studentNumber);
    /**
     * 查询老师布置作业总次数
     * @param classroomId 班级id
     * @return
     */
    public int selectHomeworkSum(int classroomId);
    /**
     * 查询学生上交作业总次数
     * @param studentNumber
     * @return
     */
    public int selectHomeworkCount(String studentNumber);
}
