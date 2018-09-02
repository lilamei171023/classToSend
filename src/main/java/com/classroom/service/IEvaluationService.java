package com.classroom.service;

import org.apache.ibatis.annotations.Param;

public interface IEvaluationService {

    public void updateHomeworkSum(@Param("homeworkSum") int homeworkSum, @Param("classroomId") int classroomId);
    public void updateHomeworkCount(@Param("homeworkCount") int homeworkCount, @Param("studentNumber") String studentNumber);
    public int selectHomeworkSum(int classroomId);
    public int selectHomeworkCount(String studentNumber);

}

