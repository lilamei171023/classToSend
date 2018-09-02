package com.classroom.service.impl;

import com.classroom.entity.Datas;
import com.classroom.service.IDatasService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class IDatasServiceImplTest {
    @Autowired
    private IDatasService iDatasService;
    @Test
    public void downloadAllDatas() throws Exception {
        iDatasService.DownloadAllDatas(1);
    }

    @Test
    public void downloadDatasByName() throws Exception {
        iDatasService.DownloadDatasByName("高数习题2",1);
    }

    @Test
    public void downloadDatasByType() throws Exception {
        iDatasService.DownloadDatasByType("高数",1);
    }

    @Test
    public void downloadDatasByNumber() throws Exception {
        iDatasService.DownloadDatasByNumber("001",1);
    }

    @Test
    public void downloadDatas() throws Exception {
        iDatasService.DownloadDatas("高数习题1");
    }
    @Test
    public void insertDatas() throws Exception {
        Datas datas=new Datas();
        datas.setTeacherNumber("1");
        datas.setDatasGener("1");
        datas.setClassroomId(1);
        datas.setDatasName("360base.dll");
        datas.setDatasPath("F");
        datas.setDatasType("dll");
        iDatasService.insertDatas(datas);
    }

    @Test
    public void deleteDatas() throws Exception {
        iDatasService.deleteDatas("1");
    }

}