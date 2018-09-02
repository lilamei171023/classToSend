package com.classroom.dao;

import com.classroom.entity.Datas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class IDatasDaoTest {
    @Autowired
    private IDatasDao iDatasDao;
    @Test
    public void downloadAllDatas() throws Exception {
        iDatasDao.DownloadAllDatas(1);
    }

    @Test
    public void downloadAllDatas1() throws Exception {
        iDatasDao.DownloadAllDatas1(1);
    }

    @Test
    public void downloadDatasByName() throws Exception {
        iDatasDao.DownloadDatasByName("高数习题1",1);
    }
    @Test
    public void downloadDatasByName1() throws Exception {
        iDatasDao.DownloadDatasByName1("高数习题1",1);
    }

    @Test
    public void downloadDatasByType() throws Exception {
        iDatasDao.DownloadDatasByType("高数",1);
    }
    @Test
    public void downloadDatasByType1() throws Exception {
        iDatasDao.DownloadDatasByType1("高数",1);
    }

    @Test
    public void downloadDatasByNumber() throws Exception {
        iDatasDao.DownloadDatasByNumber("001",1);
    }

    @Test
    public void downloadDatasByNumber1() throws Exception {
        iDatasDao.DownloadDatasByNumber1("001",1);
    }

    @Test
    public void downloadDatas() throws Exception {
        iDatasDao.DownloadDatas("高数习题1");
    }
    @Test
    public void insertDatas() throws Exception {
        Datas datas=new Datas();
        datas.setTeacherNumber("1");
        datas.setClassroomId(1);
        datas.setDatasGener("0");
        datas.setDatasName("3");
        datas.setDatasPath("3");
        datas.setDatasType("3");
        System.out.println(iDatasDao.insertDatas(datas));
    }

    @Test
    public  void deleteDatas() throws Exception{
        iDatasDao.deleteDatas("2");
    }
}