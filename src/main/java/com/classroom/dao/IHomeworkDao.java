package com.classroom.dao;

import com.classroom.entity.Homework;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IHomeworkDao {
    /**
     * 点击下载作业加载所有作业页面
     * @param classroomId 用户所在班级
     * @return
     */
    public List<Homework> DownloadAllHomework(int classroomId);

    /**
     * 点击搜索后通过作业名称模糊查询作业
     *
     * @param homeworkName
     * @param classroomId
     * @return
     */
    public List<Homework> DownloadHomeworkByName(String homeworkName, int classroomId);

    /**
     * 点击搜索后通过作业类型模糊查询作业
     *
     * @param homeworkType
     * @param classroomId
     * @return
     */
    public List<Homework> DownloadHomeworkByType(String homeworkType, int classroomId);

    /**
     * 点击搜索后通过学生账号模糊查询作业
     *
     * @param studentNumber
     * @param classroomId
     * @return
     */
    public List<Homework> DownloadHomeworkByNumber(String studentNumber, int classroomId);

    /**
     * 通过要下载的作业名称查询作业存储路径
     * @param homeworkName
     * @return
     */
    public String DownloadHomework(String homeworkName);

    /**
     * 学生上传作业
     * @param homework 前端传过来的作业数据
     * @return
     */
    public void  insertHomework(Homework homework);
    /**
     * 老师输入成绩
     * @param homeworkGrade 作业成绩
     * @param homeworkName 作业名
     * @return
     */
    public void updateHomework(@Param("homeworkGrade") String homeworkGrade, @Param("homeworkName") String homeworkName);
    /**
     * 学生删除自己的作业
     * @param homeworkName 作业名称
     * @return
     */
    public void deleteHomework(String homeworkName);

}
