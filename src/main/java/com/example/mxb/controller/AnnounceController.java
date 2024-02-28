package com.example.mxb.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mxb.entity.Announce;
import com.example.mxb.entity.Doctor;
import com.example.mxb.entity.User;
import com.example.mxb.mapper.AnnounceMapper;
import com.example.mxb.service.AnnounceService;
import com.example.mxb.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/announce")
public class AnnounceController {
    @Autowired
    private AnnounceService announceService;



    @RequestMapping("/insert")
    public String insert(@RequestBody Announce announce) {
        announceService.save(announce);
        return "添加成功";
    }

    @RequestMapping("/selectAll")
    public List<Announce> selectAll() {
        List<Announce> list = announceService.list();
        return list;
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        announceService.removeById(id);
        return "删除成功";
    }


    @RequestMapping("/update")
    public String update(@RequestBody Announce announce){
        announceService.updateById(announce);
        return "修改成功";
    }

    //通过公告标题查询公告
    @RequestMapping("/selectByTitle")
    public Announce selectByTitle(String title){
        LambdaQueryWrapper<Announce> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(Announce::getTitle,title);
        return announceService.getOne(wrapper);
    }
}
