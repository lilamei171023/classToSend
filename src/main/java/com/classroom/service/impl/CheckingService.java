package com.classroom.service.impl;

import com.classroom.dao.ICheckingDao;
import com.classroom.entity.CheckOne;
import com.classroom.entity.Evaluation;
import com.classroom.service.ICheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("checkingService")
public class CheckingService implements ICheckingService {
   @Resource
    private ICheckingDao checkingDao;


    //根据班级id查询该班级所有学生
    @Override
    public List<String > loadAllStudent(int classroom_id) {

        return checkingDao.loadAllStudent(classroom_id);
    }

    @Override
    public int selectCheckOne() {
        return checkingDao.selectCheckOne();
    }


    @Override
    public int  insertOneStudent(List<CheckOne> list) {
        return checkingDao.insertOneStudent(list);
    }

    @Override
    public int select(String student_number) {
        return checkingDao.select(student_number);
    }

    @Override
    public int selectMaxMark(List<CheckOne> list) {
        return checkingDao.selectCheckOne();
    }

    @Override
    public void  insertFirstStudent(List<Evaluation> list) {

        checkingDao.insertFirstStudent(list);
    }

    @Override
    public int updateCheckOne(List<CheckOne> c) {
        return checkingDao.updateCheckOne(c);
    }

    @Override
    public Evaluation selectEvaluation(List<Evaluation> e) {
        return checkingDao.selectEvaluation(e);
    }

    @Override
    public int updateEvaluation(List<Evaluation> e) {
        return checkingDao.updateEvaluation(e);
    }



}
