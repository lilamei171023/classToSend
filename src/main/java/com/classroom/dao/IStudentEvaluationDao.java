package com.classroom.dao;

import com.classroom.vo.response.Evaluation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IStudentEvaluationDao {
     public List<Evaluation> showEvaluation(Integer classroom_id);
}
