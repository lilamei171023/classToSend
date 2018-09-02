package com.classroom.service.impl;

import com.classroom.dao.IStudentDao;
import com.classroom.dao.ITeacherDao;
import com.classroom.dao.IUserloginDao;
import com.classroom.entity.Userlogin;
import com.classroom.service.IStudentService;
import com.classroom.service.ITeacherService;
import com.classroom.service.IUserloginService;
import com.classroom.vo.response.Msg;
import com.classroom.util.MD5Util;
import com.classroom.vo.response.People;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.classroom.util.Constants;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
/**
 * @author Lilamei
 * @date 2017/11/7 17:10
 */


@Service("userloginService")
//@Transactional(rollbackFor = Exception.class)
public class UserloginServiceImpl implements IUserloginService {

    private final  IUserloginDao iUserloginDao;
    private Logger logger= LoggerFactory.getLogger(UserloginServiceImpl.class);
    private final IStudentDao iStudentDao;
    private final ITeacherDao iTeacherDao;
    private IStudentService iStudentService;
    private ITeacherService iTeacherService;


    public UserloginServiceImpl(IUserloginDao iUserloginDao, IStudentDao iStudentDao, ITeacherDao iTeacherDao, IStudentService iStudentService, ITeacherService iTeacherService) {
        this.iUserloginDao = iUserloginDao;
        this.iStudentDao = iStudentDao;
        this.iTeacherDao = iTeacherDao;
        this.iStudentService = iStudentService;
        this.iTeacherService = iTeacherService;
    }



    /**
     * 根据Id查询用户
     * @param userloginId
     * @return
     */
    @Override
    public Userlogin getById(Integer userloginId) {
        return iUserloginDao.getById(userloginId);
    }



    /**
     * 核对登录信息
     * @param userloginNumber
     * @param userloginPwd
     * @return
     */
    @Override
    public Integer checkLogin(String userloginNumber, String userloginPwd) {
        return iUserloginDao.checkLogin(userloginNumber,userloginPwd);
    }

    /**
     * 核对登录用户详细信息
     * @param userNumber
     * @param userPwd
     * @param session
     * @return
     */
    @Override
    public Msg login(String userNumber, String userPwd,HttpSession session,String validateCode) {
        String verifyCode=(String)session.getAttribute("verifyCode");
        if (validateCode==verifyCode) {
            //1.判断用户登录信息是否正确,
            //二次加密，加盐
            String code = MD5Util.generate(userPwd, userNumber);

            Integer userloginId = checkLogin(userNumber, code);
            if (userloginId == null) {
                logger.debug("登录信息异常");
                return Msg.fail();
            }

            // 2.查询用户信息
            Userlogin userlogin = getById(userloginId);

            //保存用户信息（userloginNumber、target（标识登录者的身份））
            session.setAttribute(Constants.USERLOGIN_NUMBER, userlogin.getUserloginNumber());
            session.setAttribute(Constants.USERLOGIN_TARGET, userlogin.getTarget());

            return Msg.success();
        }
        else
            return Msg.failCodeMsg();

    }


    /**
     * 退出登录
     * @param session
     * @return
     */
    @Override
    public Msg logout(HttpSession session) {
        session.invalidate();
        return Msg.success();
    }


    /**
     * 显示用户信息
//     * @param session
     * @return
     */
    @Override
    public People showShortMessage(HttpSession session ) {
        String target,userloginNumber;
        target = (String) session.getAttribute("target");
        userloginNumber = (String) session.getAttribute("userloginNumber");
        if("1".equals(target)){
            return iStudentDao.checkShortMessage(userloginNumber);
        }else  {
            return iTeacherDao.checkShortMessage(userloginNumber);
        }
//        return iStudentDao.checkShortMessage("100001");
    }

    @Override
    public Userlogin selectByUsername(String userloginNumber) {
        return iUserloginDao.selectByUserloginName(userloginNumber);
    }


    /**
     * 修改用户信息
     * @param userloginName
     * @param userloginNo
     * @param schoolName
     * @param session
     * @return
     */
    @Override
    public Msg updateInformation(String userloginName,String userloginNo,String schoolName,HttpSession session) {
        String target = (String) session.getAttribute("target");
        String userloginNumber=(String) session.getAttribute("userloginNumber");
        if ("1".equals(target)) {
            return iStudentService.updateStudentInformation(userloginNumber,userloginName,userloginNo,schoolName);
        } else if ("0".equals(target)) {
            return iTeacherService.updateTeacherInformation(userloginNumber,userloginName,userloginNo,schoolName);
        }
        return Msg.fail();
    }





    /**
     * 修改登录密码
     * @param oldPwd
     * @param newPwd
     * @return  消息Msg对象
     */
    @Override
    public Msg updatePwd( String oldPwd, String newPwd,HttpSession session) {
        String target = (String) session.getAttribute("target");
        String userloginNumber = (String) session.getAttribute("userloginNumber");
        if (iUserloginDao.checkLogin(userloginNumber,oldPwd)!=0) {
            if ("1".equals(target)) {
                return iStudentService.updatePwd(userloginNumber,newPwd);
            } else if ("0".equals(target)) {
                return iTeacherService.updatePwd(userloginNumber,newPwd);
            }
        }
        return Msg.fail();

    }

}


