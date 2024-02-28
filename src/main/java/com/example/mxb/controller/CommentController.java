package com.example.mxb.controller;

import com.example.mxb.entity.Comment;
import com.example.mxb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;



    @RequestMapping("/insert")
    public String insert(@RequestBody Comment comment) {
        commentService.save(comment);
        return "添加成功";
    }

    @RequestMapping("/selectAll")
    public List<Comment> selectAll() {
        List<Comment> list = commentService.list();
        return list;
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        commentService.removeById(id);
        return "删除成功";
    }


    @RequestMapping("/update")
    public String update(@RequestBody Comment comment){
        commentService.updateById(comment);
        return "修改成功";
    }
}
