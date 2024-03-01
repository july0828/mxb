package com.example.mxb.controller;

import com.example.mxb.entity.Plan;
import com.example.mxb.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanService planService;



    @RequestMapping("/insert")
    public String insert(@RequestBody Plan plan) {
        planService.save(plan);
        return "添加成功";
    }

    @RequestMapping("/selectAll")
    public List<Plan> selectAll() {
        List<Plan> list = planService.list();
        return list;
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        planService.removeById(id);
        return "删除成功";
    }


    @RequestMapping("/update")
    public String update(@RequestBody Plan plan){
        planService.updateById(plan);
        return "修改成功";
    }
}
