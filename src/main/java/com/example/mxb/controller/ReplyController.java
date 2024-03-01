package com.example.mxb.controller;

import com.example.mxb.entity.Reply;
import com.example.mxb.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;



    @RequestMapping("/insert")
    public String insert(@RequestBody Reply reply) {
        replyService.save(reply);
        return "添加成功";
    }

    @RequestMapping("/selectAll")
    public List<Reply> selectAll() {
        List<Reply> list = replyService.list();
        return list;
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        replyService.removeById(id);
        return "删除成功";
    }


    @RequestMapping("/update")
    public String update(@RequestBody Reply reply){
        replyService.updateById(reply);
        return "修改成功";
    }
}
