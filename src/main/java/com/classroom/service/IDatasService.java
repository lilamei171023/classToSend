package com.classroom.service;

import com.classroom.entity.Datas;

import java.util.List;

public interface IDatasService {
    /**
     * 加载资料页面
     */
    public List<Datas> DownloadAllDatas(int classroomId);
    public List<Datas> DownloadAllDatas1(int classroomId);

    /**
     * 通过资料名称模糊查询资料页面
     */
    public List<Datas> DownloadDatasByName(String datasName, int classroomId);
    public List<Datas> DownloadDatasByName1(String datasName, int classroomId);

    /**
     * 通过资料类型模糊查询资料页面
     */
    public List<Datas> DownloadDatasByType(String datasType, int classroomId);
    public List<Datas> DownloadDatasByType1(String datasType, int classroomId);

    /**
     * 通过老师账号模糊查询资料页面
     */
    public List<Datas> DownloadDatasByNumber(String teacherNumber, int classroomId);
    public List<Datas> DownloadDatasByNumber1(String teacherNumber, int classroomId);

    /**
     * 通过要下载的资料名称查找资料存储路径
     */
    public String DownloadDatas(String datasName);


    public void insertDatas(Datas datas);
    public void deleteDatas(String datasName);
}
