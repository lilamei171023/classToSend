package com.classroom.service;

import com.classroom.entity.Homework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IHomeworkService {
    /**
     * 点击下载作业加载所有作业页面
     *
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
     * @param stduentNumber
     * @param classroomId
     * @return
     */
    public List<Homework> DownloadHomeworkByNumber(String stduentNumber, int classroomId);
    /**
     * 通过要下载的作业名称查询作业存储路径
     * @param homeworkName
     * @return
     */
    public String DownloadHomework(String homeworkName);

    public void insertHomework(Homework homework);
    public void updateHomework(@Param("homeworkGrade") String homeworkGrade, @Param("homeworkGame") String homeworkName);
    public void deleteHomework(String homeworkName);


}

