package com.classroom.service.impl;

import com.classroom.dao.IStudentEvaluationDao;
import com.classroom.service.IStudentEvaluationService;
import com.classroom.vo.response.Evaluation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("StudentEvaluationService")
public class StudentEvaluationService implements IStudentEvaluationService {
    @Resource
    private IStudentEvaluationDao iStudentEvaluationDao ;
    public List<Evaluation> showEvaluation(Integer classroom_id){
        return  iStudentEvaluationDao.showEvaluation(classroom_id);
    }
}

