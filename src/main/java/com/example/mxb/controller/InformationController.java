package com.example.mxb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mxb.entity.About;
import com.example.mxb.entity.Appointment;
import com.example.mxb.entity.Information;
import com.example.mxb.mapper.InformationMapper;
import com.example.mxb.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    private InformationMapper informationMapper;



    @Autowired
    private InformationService informationService;

    @RequestMapping("/add")
    public String Add(@RequestBody Information information){
        informationService.save(information);
        return "添加成功";
    }

    //查询所有知识
    @RequestMapping("/selectAll")
    public List<Information> selectAll(){
        List<Information> informations=informationService.list();
        return informations;
    }

    @RequestMapping("/selectAllById")
    public Information selectAllById(@RequestParam Integer id) {
        return informationService.getById(id);
    }
    //修改医生
    @RequestMapping("/update")
    public String update(@RequestBody Information information){
        informationService.saveOrUpdate(information);
        return "修改成功";
    }

    //删除医生
    @RequestMapping("/delete")
    public String delete(Integer id){
        informationService.removeById(id);
        return "删除成功";
    }
}
