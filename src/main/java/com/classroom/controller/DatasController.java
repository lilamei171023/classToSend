package com.classroom.controller;

import com.classroom.entity.Datas;
import com.classroom.service.IDatasService;
import com.classroom.service.impl.DatasServiceImpl;
import com.classroom.service.impl.EvaluationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
public class DatasController {
    private Logger logger= LoggerFactory.getLogger(DatasController.class);

    @Resource
    private IDatasService datasService;
    private int homeworkSum=0;
    @Autowired
    private EvaluationServiceImpl evaluationService;
    int count=0;

    /**
     * 学生点击下载资料加载所有资料页面
     * @param model 将查找到的信息添加到模型视图中，再返回给前台
     * @param classroomId
     * @return
     */
    @RequestMapping(value="/DownloadAllDatas")
    public String DownloadAllDatas(Model model, int classroomId, String datasGener) {
        List<Datas> dA = new ArrayList<>();
        if(datasGener=="1") {
            dA = datasService.DownloadAllDatas(classroomId);
        }else{
           dA=datasService.DownloadAllDatas1(classroomId);
        }

        model.addAttribute("allDatas",dA);
        return "allDatas";
    }

    /**
     * 通过资料名称和班级id模糊查询
     * @param model
     * @param datasName
     * @param classroomId
     * @return
     */
    @RequestMapping(value="/DownloadDatasByName")
    public String DownloadDatasByName(Model model, String datasName, int classroomId, String datasGener) {
        List<Datas> dN =new ArrayList<>();
        if(datasGener=="1") {
            dN = datasService.DownloadDatasByName(datasName, classroomId);
        }else{
            dN=datasService.DownloadDatasByName1(datasName,classroomId);
        }
        model.addAttribute("datasName", dN);
        return "datasName";
    }

    /**
     * 通过资料类型和班级id模糊查询
     * @param model
     * @param session
     * @param userLoginTarget
     * @param datasType
     * @param classroomId
     * @return
     */
    @RequestMapping("/DownloadDatasByType")
    public String DownloadDatasByType(Model model, HttpSession session, String userLoginTarget, String datasType, int classroomId, String datasGener) {
        List<Datas> dT =new ArrayList<>();
        if(datasGener=="1") {
            dT = datasService.DownloadDatasByType(datasType, classroomId);
        }else{
            dT=datasService.DownloadDatasByType1(datasType,classroomId);
        }
        model.addAttribute("datasType", dT);
        return "datasType";
    }

    /**
     * 通过老师账号和班级id模糊查询
     * @param model
     * @param session
     * @param userLoginTarget
     * @param teacherNumber
     * @param classroomId
     * @return
     */
    @RequestMapping("/DownloadDatasByNumber")
    public String DownloadDatasByNumber(Model model, HttpSession session, String userLoginTarget, String teacherNumber, int classroomId, String datasGener) {
        List<Datas> dN =new ArrayList<>();
        if(datasGener=="1") {
            dN = datasService.DownloadDatasByNumber(teacherNumber, classroomId);
        }else{
            dN=datasService.DownloadDatasByNumber1(teacherNumber, classroomId);
        }
        model.addAttribute("datasType", dN);
        return "datasType";
    }

    /**
     * 通过资料名称查询资料存储路径，然后以字节流的方式下载作业
     * @param request
     * @param response
     * @param DatasName
     * @return
     */
    @ResponseBody
    @RequestMapping("/DownloadDatas")
    public String DownloadDatas(HttpServletRequest request, HttpServletResponse response, String DatasName) {
        String datasPath=datasService.DownloadDatas(DatasName);
        response.setHeader("Content-Disposition", "attachment;fileName="+DatasName);
        //InputStream is = request.getServletContext().getResourceAsStream("/db.properties")相当于项目工程根目录
        //下载文件路径 String path = request.getServletContext().getRealPath("/images/");
        //   InputStream getResourceAsStream(String path)  返回servlet引擎的名称
        InputStream is=request.getServletContext().getResourceAsStream(datasPath+DatasName);
        byte[] bs=null;
        if(is==null){
            return  "1";
        } else{
            try {
                bs = new byte[is.available()];
                is.read(bs, 0, bs.length);
            }catch (IOException e) {
                e.printStackTrace();
            }
            return "0";
        }
    }







    /**
     * 老师上传资料或作业
     * @param request 请求
     * @param classroomId 班级id
     * @param datasGenre 标志（资料还是作业）
     * @return
     */
    @RequestMapping(value="/uploadDatas", method= RequestMethod.POST)
    @ResponseBody
    public String upLoadFile(HttpServletRequest request, Integer classroomId, String datasGenre)
            throws IllegalStateException, IOException {
        Datas datas=new Datas();
        logger.info("进入上传方法");
        // @RequestParam("file") MultipartFile file,
        //创建一个多分解的容器
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            logger.info("判断 request 是否有文件上传,即多部分请求");
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter=multiRequest.getFileNames();
            while (iter.hasNext()) {
                logger.info("取得request中的所有文件名");
                // 取得上传文件
                MultipartFile f=multiRequest.getFile(iter.next());
                if (f != null) {
                    // 取得当前上传文件的文件名称
                    logger.info("取得当前上传文件的文件名称");
                    String myFileName=f.getOriginalFilename();
                    count=count+1;
                    myFileName="000"+count+myFileName;
                    String res = myFileName.substring(myFileName.lastIndexOf(".") + 1).toLowerCase();
                    datas.setDatasName(myFileName);
                    datas.setDatasType(res);

                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        // 定义上传路径
                        logger.info(" 如果名称不为“”,说明该文件存在，否则说明该文件不存在");
                        String path="F:\\Users\\资料\\" + myFileName;
                        datas.setDatasPath(path);
                        File localFile=new File(path);
                        f.transferTo(localFile);
                    }
                }
            }
        }
        String teacher_number=request.getSession().getAttribute("userNumber").toString();
        datas.setClassroomId(classroomId);
        datas.setTeacherNumber("1");
        datas.setDatasGener(datasGenre);
        datasService.insertDatas(datas);
        if(datasGenre.equals( "0"))
        {
            homeworkSum= evaluationService.selectHomeworkSum(classroomId);
            homeworkSum=homeworkSum+1;
            evaluationService.updateHomeworkSum(homeworkSum,classroomId);
        }

        return "0";
    }

    /**
     * 老师删除作业或资料
     * @param datasName 资料名称
     * @param datasGenre 标志（作业或资料）
     * @param classroomId 班级id
     * @return
     */
    @RequestMapping("/deleteDatas")
    @ResponseBody
    public String deleteDatas( String datasName, String datasGenre,int classroomId){
        datasService.deleteDatas(datasName);
        if(datasGenre.equals("0")){
            homeworkSum= evaluationService.selectHomeworkSum(classroomId);
            homeworkSum=homeworkSum-1;
            evaluationService.updateHomeworkSum(homeworkSum,classroomId);
        }
        return "0";
    }





}
