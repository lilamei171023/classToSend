package com.classroom.controller;

import com.classroom.entity.Homework;
import com.classroom.service.IEvaluationService;
import com.classroom.service.IHomeworkService;
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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

@Controller
public class HomeworkController {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Resource
    private IHomeworkService homeworkService;
    private int homeworkCount=0;
    int count=0;
    @Autowired
    private IEvaluationService iEvaluationService;

    /**
     * 通过班级id查询资料
     * @param model
     * @param classroomId
     * @return
     */
    @RequestMapping("/DownloadAllHomework")
    public String DownloadAllHomework(Model model, int classroomId){
        List<Homework> hA=homeworkService.DownloadAllHomework(classroomId);
        model.addAttribute("allHomework",hA);
        return "allHomework";
    }

    /**
     * 通过作业名称和班级id 模糊查询
     * @param model
     * @param homeworkName
     * @param classroomId
     * @return
     */
    @RequestMapping("/DownloadHomeworkByName")
    public String DownloadHomeworkByName(Model model, String homeworkName, int classroomId){
        List<Homework> hN=homeworkService.DownloadHomeworkByName(homeworkName, classroomId);
        model.addAttribute("homeworkName",hN);
        return  "homeworkName";
    }

    /**
     * 通过作业类型和班级id 模糊查询
     * @param model
     * @param homeworkType
     * @param classroomId
     * @return
     */
    @RequestMapping("/DownloadHomeworkByType")
    public String DownloadHomeworkByType(Model model, String homeworkType, int classroomId){
        List<Homework> hT=homeworkService.DownloadHomeworkByType(homeworkType, classroomId);
        model.addAttribute("homeworkType",hT);
        return "homeworkType";
    }

    /**
     * 通过学生账号和班级id 模糊查询
     * @param model
     * @param studentNumber
     * @param classroomId
     * @return
     */
    @RequestMapping("/DownloadHomeworkByNumber")
    public String DownloadHomeworkByNumber(Model model, String studentNumber, int classroomId){
        List<Homework> hN=homeworkService.DownloadHomeworkByNumber(studentNumber,classroomId);
        model.addAttribute("homeNumber",hN);
        return "homeworkNumber";
    }

    /**
     * 通过作业名称查询作业存储路径，然后以字节流的方式下载作业
     * @param request
     * @param response
     * @param homeworkName
     * @return
     */
    @RequestMapping("/DownloadHomework")
    public String DownloadHomework(HttpServletRequest request, HttpServletResponse response, String homeworkName){
        String homeworkPath=homeworkService.DownloadHomework(homeworkName);
        response.setHeader("Content-Disposition", "attachment;fileName="+homeworkName);
        //request.getSession().getServletContext()// 获取的是page的上下文。
        //request.getSession().getServletContext().getRealPath(“”); 是获取的的tamcat的路径，部署项目后相当于项目的路径。
        InputStream is=request.getServletContext().getResourceAsStream(homeworkPath+homeworkName);
        byte[] bs=null;
        if(is==null) {
            return "1";
        }else {
            try {
                bs = new byte[is.available()];
                is.read(bs, 0, bs.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "0";
        }
    }




    /**
     * 学生上传作业
     * @param request 请求
     * @param classroomId 班级id
     * @return
     */
    @RequestMapping(value="/uploadHomework", method= RequestMethod.POST)
    @ResponseBody
    public String upLoadFile1(HttpServletRequest request,int classroomId)
            throws IllegalStateException, IOException {
        Homework homework=new Homework();
        logger.info("进入上传方法");
        // @RequestParam("file") MultipartFile file,
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
                    homework.setHomeworkName(myFileName);
                    homework.setHomeworkType(res);
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    int count=0;
                    if (myFileName.trim() != "") {
                        count=count+1;
                        // 定义上传路径
                        logger.info(" 如果名称不为“”,说明该文件存在，否则说明该文件不存在");
                        String path="F:\\Users\\作业\\" + myFileName;
                        homework.setHomeworkPath(path);
                        File localFile=new File(path);
                        f.transferTo(localFile);
                    }
                }
            }
        }

        String studentNumber=request.getSession().getAttribute("studentNumber").toString();

        homework.setClassroomId(classroomId);
        homework.setStudentNumber("1");
        homeworkService.insertHomework(homework);
        homeworkCount=iEvaluationService.selectHomeworkCount("1");
        homeworkCount=homeworkCount+1;
        iEvaluationService.updateHomeworkCount(homeworkCount,"1");

        return "0";
    }


    /**
     * 老师输入成绩
     * @param homeworkName 作业名称
     * @param homeworkGrade 成绩
     * @return
     */
    @RequestMapping("/uploadGrade")
    @ResponseBody
    public String uploadGrade(String homeworkName,String homeworkGrade){
        homeworkService.updateHomework(homeworkGrade,homeworkName);
        return "0";
    }

    /**
     * 学生删除作业
     * @param request 请求
     * @param homeworkName 作业名
     * @return
     */
    @RequestMapping("/deleteHomework")
    @ResponseBody
    public String deleteHomework(HttpServletRequest request,String homeworkName){
        logger.info("111111");
        homeworkService.deleteHomework(homeworkName);
        String studentNumber=request.getSession().getAttribute("studentNumber").toString();
        homeworkCount=iEvaluationService.selectHomeworkCount("1");
        logger.info("2222");
        homeworkCount=homeworkCount-1;
        logger.info("3333");
        iEvaluationService.updateHomeworkCount(homeworkCount,"1");
        return "0";
    }

}
