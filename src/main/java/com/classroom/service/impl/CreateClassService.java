package com.classroom.service.impl;

import com.classroom.dao.ICreateClassDao;
import com.classroom.service.ICreateClassService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("CreateClassService")
public class CreateClassService implements ICreateClassService {
    @Resource
    private ICreateClassDao iCreateClassDao;
    public  int  createClass( String  classroomName,  String  invitationCode){
       return  iCreateClassDao.createClass(classroomName,invitationCode);
    }
    public  int  searchClassroomId(String invitationCode){
       return  iCreateClassDao.searchClassroomId(invitationCode);
    }
}
