package com.classroom.service.impl;

import com.classroom.dao.IDatasDao;
import com.classroom.entity.Datas;
import com.classroom.service.IDatasService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DatasServiceImpl implements IDatasService {
    @Resource
    private IDatasDao iDatasDao;

    public DatasServiceImpl() {
    }

    public DatasServiceImpl(IDatasDao iDatasDao) {
        this.iDatasDao=iDatasDao;
    }
    @Override
    public List<Datas> DownloadAllDatas1(int classroomId) {
        return iDatasDao.DownloadAllDatas1(classroomId);
    }

    @Override
    public List<Datas> DownloadDatasByName1(String datasName, int classroomId) {
        return iDatasDao.DownloadDatasByName1(datasName, classroomId);
    }

    @Override
    public List<Datas> DownloadDatasByType1(String datasType, int classroomId) {
        return iDatasDao.DownloadDatasByType1(datasType, classroomId);
    }

    @Override
    public List<Datas> DownloadDatasByNumber1(String teacherNumber, int classroomId) {
        return iDatasDao.DownloadDatasByNumber1(teacherNumber, classroomId);
    }

    @Override
    public List<Datas> DownloadAllDatas(int classroomId) {
        return iDatasDao.DownloadAllDatas(classroomId);
    }

    @Override
    public List<Datas> DownloadDatasByName(String datasName, int classroomId) {
        return iDatasDao.DownloadDatasByName(datasName, classroomId);
    }

    @Override
    public List<Datas> DownloadDatasByType(String datasType, int classroomId) {
        return iDatasDao.DownloadDatasByName(datasType, classroomId);
    }

    @Override
    public List<Datas> DownloadDatasByNumber(String teacherNumber, int classroomId) {
        return iDatasDao.DownloadDatasByNumber(teacherNumber, classroomId);
    }

    @Override
    public String DownloadDatas(String datasName) {
        return iDatasDao.DownloadDatas(datasName);
    }


    public void insertDatas(Datas datas){this.iDatasDao.insertDatas(datas);}
    public void deleteDatas(String datasName){this.iDatasDao.deleteDatas(datasName);}

}
