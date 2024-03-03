package com.example.mxb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mxb.entity.Appointment;
import com.example.mxb.entity.Question;
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

    @RequestMapping("/selectByNum")
    public List<Reply> selectAllByDoctorNum(Integer num) {
        LambdaQueryWrapper<Reply> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Reply::getDoctorNum, num);
        return replyService.list(wrapper);
    }

    @RequestMapping("/selectAllById")
    public List<Reply> selectAllById(Integer userId) {
        LambdaQueryWrapper<Reply> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(Reply::getAccountId,userId);
        return replyService.list(wrapper);
    }
}
