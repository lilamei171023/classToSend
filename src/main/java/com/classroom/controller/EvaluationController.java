package com.classroom.controller;

import com.classroom.service.IStudentEvaluationService;
import com.classroom.vo.response.Evaluation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/Evaluation")
public class EvaluationController {
    @Resource
    private IStudentEvaluationService studentEvaluationService;
    /*
    * 查询一个班级的期末总评
    * @classroom_id 班级id
    * @return
    * */
    @RequestMapping(value="/searchEvaluation",method= RequestMethod.POST)
    @ResponseBody
    public List<Evaluation> searchEvaluation(int classroom_id){
        return  studentEvaluationService.showEvaluation(classroom_id);
    }
}
