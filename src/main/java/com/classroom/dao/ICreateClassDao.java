package com.classroom.dao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ICreateClassDao {
    int  createClass(@Param("classroomName") String classroomName, @Param("invitationCode") String invitationCode);
    int  searchClassroomId(String invitationCode);
}
