package com.classroom.dao;

import com.classroom.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IUserDao {

    User selectUser(long id);

}
