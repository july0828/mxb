package com.example.mxb.controller;

import com.example.mxb.entity.Reminder;
import com.example.mxb.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reminder")
public class ReminderController {
    @Autowired
    private ReminderService reminderService;



    @RequestMapping("/insert")
    public String insert(@RequestBody Reminder reminder) {
        reminderService.save(reminder);
        return "添加成功";
    }

    @RequestMapping("/selectAll")
    public List<Reminder> selectAll() {
        List<Reminder> list = reminderService.list();
        return list;
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        reminderService.removeById(id);
        return "删除成功";
    }


    @RequestMapping("/update")
    public String update(@RequestBody Reminder reminder){
        reminderService.updateById(reminder);
        return "修改成功";
    }
}
