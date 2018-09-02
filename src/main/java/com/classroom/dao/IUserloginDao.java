package com.classroom.dao;
import com.classroom.entity.Userlogin;
import com.classroom.vo.response.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * @author LiLaMei
 * @date 2017/11/7 17:10
 */

@Mapper
@Repository
public interface IUserloginDao {
    /**
     * 根据id查询userlogin对象
     */
    Userlogin getById(  @Param("userloginId") Integer userloginId);
    /**
     * 将用户信息与登录表（userlogin）中信息核对
     */
    Userlogin selectByUserloginName( @Param("userloginNumber") String userloginNumber);
    Integer checkLogin( @Param("userloginNumber") String userloginNumber,
                        @Param("userloginPwd")String userloginPwd);
    /**
     * 添加一个用户到Userlogin表中
     */

    Integer addUserlogin(Userlogin userlogin);
    /**
     * 在Userlogin表中修改学生登录密码
     */
    Integer updatePwd(@Param("userloginNumber") String userloginNumber,
                      @Param("userloginPwd") String userloginPwd);



}
