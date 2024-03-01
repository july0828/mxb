package com.example.mxb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mxb.entity.Account;
import com.example.mxb.entity.Appointment;
import com.example.mxb.entity.Doctor;
import com.example.mxb.mapper.AppointmentMapper;
import com.example.mxb.mapper.DoctorMapper;
import com.example.mxb.service.AppointmentService;
import com.example.mxb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/appointment")
@RestController
public class AppointmentController {
    @Autowired
    private AppointmentMapper appointmentMapper;

    @Resource
    private AppointmentService appointmentService;

    //添加预约
    @RequestMapping("/insert")
    public String insert(@RequestBody Appointment appointment) {
        appointmentService.save(appointment);
        return "预约成功";
    }

    @RequestMapping("/selectAll")
    public List<Appointment> selectAll() {
        List<Appointment> list = appointmentService.list();
        return list;
    }

    @RequestMapping("/selectAllById")
    public List<Appointment> selectAllById(Integer userId) {
        LambdaQueryWrapper<Appointment> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(Appointment::getUserId,userId);
        return appointmentService.list(wrapper);
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        appointmentService.removeById(id);
        return "删除成功";
    }
}
