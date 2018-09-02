package com.classroom.dao;

import com.classroom.entity.CheckOne;
import com.classroom.entity.Evaluation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* 考勤接口
* */
@Repository
@Mapper
public interface ICheckingDao {
    //根据班级id查询该班级所有学生
    List<String > loadAllStudent(int classroomId);
    //查询表check_one是否为空

    int selectCheckOne();
    //建立学生签到详情的表数据

    int insertOneStudent(List<CheckOne> list);
    //根据student_number查询classroom_id

    int select(String studentNumber);

    //查询最大mark  目前签到的次数
    int selectMaxMark(List<CheckOne> list);

    //建立evaluation表该学生数据
    void insertFirstStudent(List<Evaluation> list);

    //跟新学生签到的表
    int updateCheckOne(List<CheckOne> c);

    //查询当前上一次签到数据
    Evaluation selectEvaluation(List<Evaluation> e);

    //跟新evaluation表
    int updateEvaluation(List<Evaluation> e);

}
