package com.classroom.controller;

import com.classroom.code.ValidateCode;
import com.classroom.service.IUserloginService;
import com.classroom.vo.response.Msg;
import com.classroom.vo.response.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static com.classroom.code.ValidateCode.generateImageCode;


@Controller
@RequestMapping("/userlogin")
/**
 * @author  Lilamei
 * @Date 2017/11/2 20:55
 */
public class UserloginController {

    //private Logger logger= (Logger) LoggerFactory.getLogger(UserloginController.class);
    @Resource
    private IUserloginService iUserloginService;


    /**
     * 生成验证码
     * @param session
     * @param response
     * @throws IOException
     * @ValidateCode.generateTextCode(验证码字符类型,验证码长度,需排除的特殊字符)
     * @ValidateCode.generateImageCode(文本验证码,图片宽度,图片高度,干扰线的条数,字符的高低位置是否随机,图片颜色,字体颜色,干扰线颜色)
     */


    @RequestMapping(value = "/validateCode", method= RequestMethod.GET)
    public void creatCode(HttpSession session, HttpServletResponse response) throws IOException {
      //指示请示或响应消息不能缓存
        response.setHeader("Cache-Control", "no-cache");
        String verifyCode = ValidateCode.generateTextCode(ValidateCode.TYPE_NUM_LOWER, 4, null);
        session.setAttribute("validateCode", verifyCode);
        response.setContentType("image/jpeg");
        BufferedImage bim = generateImageCode(verifyCode, 90, 30, 5, true, Color.WHITE, Color.BLUE, null);
        ImageIO.write(bim, "JPEG", response.getOutputStream());
    }


    /**
     * 登录方法， 检查登录信息，如果信息正确，则将userloginId，target（表示身份）放入session中
     * @param userloginNumber
     * @param userloginPwd
     * @return 消息Msg 对象
     */

    @RequestMapping(value="/login", method= RequestMethod.POST)
    @ResponseBody
     public Msg login(String userloginNumber, String userloginPwd,HttpSession session,String code){
       // logger.debug("进入login方法:"+userloginNumber+" "+userloginPwd);

        return iUserloginService.login(userloginNumber,userloginPwd,session,code);
     }

    /**
     * 退出登录 清除session中的
     * @return  消息Msg 对象
     */

     @RequestMapping(value = "/logout",method = RequestMethod.POST)
     @ResponseBody
     public Msg logout(HttpSession session){
         return iUserloginService.logout(session);
     }

    /**
     * 显示用户信息
     * @return student或者teacher对象
     */
    @RequestMapping(value = "/showMessage",method = RequestMethod.GET)
    @ResponseBody
    public People showMessage(HttpServletResponse response, HttpSession session){
        response.setHeader("Access-Control-Allow-Origin","*");
        return iUserloginService.showShortMessage(session);
    }


    @RequestMapping(value = "/updateInformation",method = RequestMethod.POST)
    @ResponseBody
    public Msg updateInformation(String userloginName,String userloginNo,String schoolName,HttpSession session){
        return iUserloginService.updateInformation(userloginName,userloginNo,schoolName,session);
    }



    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public Msg updatePwd(String oldPwd,String newPwd,HttpSession session){
        return iUserloginService.updatePwd(oldPwd,newPwd,session);}

}
