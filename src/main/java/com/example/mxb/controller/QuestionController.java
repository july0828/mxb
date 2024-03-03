package com.example.mxb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mxb.entity.Doctor;
import com.example.mxb.entity.Question;
import com.example.mxb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;



    @RequestMapping("/insert")
    public String insert(@RequestBody Question question) {
        questionService.save(question);
        return "添加成功";
    }

    @RequestMapping("/selectAll")
    public List<Question> selectAll() {
        List<Question> list = questionService.list();
        return list;
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        questionService.removeById(id);
        return "删除成功";
    }


    @RequestMapping("/update")
    public String update(@RequestBody Question question){
        questionService.updateById(question);
        return "修改成功";
    }

    //通过医生工号num查询问题
    @RequestMapping("/selectByDoctorNum")
    public Question selectByDoctorNum(Integer doctorNum){
        LambdaQueryWrapper<Question> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(Question::getDoctorNum,doctorNum);
        System.out.println(doctorNum);
        return questionService.getOne(wrapper);
    }
    @RequestMapping("/selectAllByDoctorNum")
    public List<Question> selectAllByDoctorNum(Integer doctorNum) {
        LambdaQueryWrapper<Question> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Question::getDoctorNum, doctorNum);
        return questionService.list(wrapper);
    }

    //通过问题id查询问题
    @RequestMapping("/selectByquestionId")
    public Question selectByquestionId(Integer questionId){
        LambdaQueryWrapper<Question> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(Question::getId,questionId);
        return questionService.getOne(wrapper);
    }

}
