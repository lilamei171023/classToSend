package com.classroom.service.impl;

import com.classroom.service.IEvaluationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("evaluationService")
public class EvaluationServiceImpl implements IEvaluationService {
    @Resource
    private com.classroom.dao.IEvaluationDao iEvaluationDao;
    public void updateHomeworkSum(@Param("homeworkSum") int homeworkSum, @Param("classroomId") int classroomId){this.iEvaluationDao.updateHomeworkSum(homeworkSum,classroomId);}
    public void updateHomeworkCount(@Param("homeworkCount") int homeworkCount, @Param("studentNumber") String studentNumber){
      this.iEvaluationDao.updateHomeworkCount(homeworkCount,studentNumber);
    }
    public int selectHomeworkSum(int classroomId){return  this.iEvaluationDao.selectHomeworkSum(classroomId);}
    public int selectHomeworkCount(String studentNumber){return this.iEvaluationDao.selectHomeworkCount(studentNumber);}


}
