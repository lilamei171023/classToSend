package com.classroom.service;

import com.classroom.vo.response.Evaluation;

import java.util.List;

public interface IStudentEvaluationService{
    public List<Evaluation> showEvaluation(Integer classroom_id);
}