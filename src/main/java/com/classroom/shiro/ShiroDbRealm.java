package com.classroom.shiro;

import com.classroom.entity.ShiroUser;
import com.classroom.entity.Userlogin;
import com.classroom.service.IUserloginService;
import org.apache.log4j.LogManager;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public class ShiroDbRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LogManager.getLogger(ShiroDbRealm.class);


    @Autowired
    private IUserloginService iUserloginService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        LOGGER.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Userlogin un = iUserloginService.selectByUsername(token.getUsername());

        // 账号不存在
        if (un == null) {
            return null;
        }
        ShiroUser shiroUser = new ShiroUser(un.getUserloginId(), un.getUserloginNumber());
        // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, un.getUserloginPwd().toCharArray(), getName());


    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
// TODO Auto-generated method stub
        return null;
    }

}
