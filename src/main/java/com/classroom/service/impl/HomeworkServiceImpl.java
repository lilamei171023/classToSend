package com.classroom.service.impl;

import com.classroom.dao.IHomeworkDao;
import com.classroom.entity.Homework;
import com.classroom.service.IHomeworkService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeworkServiceImpl implements IHomeworkService {
    @Resource
    private IHomeworkDao iHomeworkDao;

    @Override
    public List<Homework> DownloadAllHomework(int classroomId) {
        return  iHomeworkDao.DownloadAllHomework(classroomId);
    }

    @Override
    public List<Homework> DownloadHomeworkByName(String homeworkName, int classroomId) {
        return iHomeworkDao.DownloadHomeworkByName(homeworkName, classroomId);
    }

    @Override
    public List<Homework> DownloadHomeworkByType(String homeworkType, int classroomId) {
        return iHomeworkDao.DownloadHomeworkByType(homeworkType, classroomId);
    }

    @Override
    public List<Homework> DownloadHomeworkByNumber(String studentNumber, int classroomId) {
        return iHomeworkDao.DownloadHomeworkByNumber(studentNumber, classroomId);
    }

    @Override
    public String DownloadHomework(String homeworkName) {
        return iHomeworkDao.DownloadHomework(homeworkName);
    }

    public void insertHomework(Homework homework){this.iHomeworkDao.insertHomework(homework);}
    public void updateHomework(@Param("homeworkGrade") String homeworGrade, @Param("homeworkName") String homeworkName)
    {this.iHomeworkDao.updateHomework(homeworGrade,homeworkName);}
    public void deleteHomework(String homeworkName){this.iHomeworkDao.deleteHomework(homeworkName);}

}
