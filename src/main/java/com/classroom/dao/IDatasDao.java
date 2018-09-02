package com.classroom.dao;

import com.classroom.entity.Datas;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jinruili
 * @time 2017.10.31
 */

@Mapper
@Repository
public interface IDatasDao {
//    public List<Datas> loadName(@param("datasName")String datasName,@param("classroomId")int classroomId );
//    public List<Datas> loadType(@param("datasType")String datasType,@param("classroomId")int classroomId);
//    public List<Datas> loadId(@param("teacherId")int teacherId, @param("classroomId")int classroomId);

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


    /**
     * 老师上传资料或作业
     * @param datas 前端传过来的资料的数据
     * @return
     */
    public int insertDatas(Datas datas);
    /**
     * 老师删除自己的作业
     * @param datasName 资料的名字
     * @return
     */
    public void  deleteDatas(String datasName);



}
