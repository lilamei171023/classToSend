package com.classroom.service.impl;

import com.classroom.dao.IUserDao;
import com.classroom.entity.User;
import com.classroom.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}
