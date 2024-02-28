package com.example.mxb.controller;

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
}
