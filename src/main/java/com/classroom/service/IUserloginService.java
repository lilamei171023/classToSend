package com.classroom.service;

import com.classroom.entity.Userlogin;

import com.classroom.vo.response.Msg;
import com.classroom.vo.response.People;

import javax.servlet.http.HttpSession;

/**
 * @author LiLaMei
 * @date 2017/11/7 17:10
 */
public interface IUserloginService {
    /**
     * 登录方法
     * @param username
     * @param password
     * @return 消息Msg对象
     */
    Msg login(String username, String password,HttpSession session,String validateCode);

    /**
     * 核对登录账号和密码
     * @param userNumber
     * @param userPwd
     * @return
     */
    Integer checkLogin(String userNumber,String userPwd);

    /**
     * 查询userlogin对象
     * @param userloginId
     * @return Userlogin对象
     */
    Userlogin getById(Integer userloginId);

    /**
     * 退出登录
     * @return 消息Msg对象
     */
    Msg logout(HttpSession session);

    /**
     * 查询登录用户对象
     * @return  Teacher/Student 对象
     */
    People showShortMessage(HttpSession session);


    Userlogin selectByUsername(String userloginNumber);

    Msg updatePwd(String oldPwd,String newPwd,HttpSession session);

    Msg updateInformation(String userloginName,String userloginNo,String schoolName,HttpSession session);
}
