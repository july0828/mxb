package com.example.mxb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mxb.entity.Appointment;
import com.example.mxb.entity.Doctor;
import com.example.mxb.entity.User;
import com.example.mxb.mapper.DoctorMapper;
import com.example.mxb.service.DoctorService;
import com.example.mxb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //添加用户
    @RequestMapping("/insert")
    public String insert(@RequestBody User user){
       userService.save(user);
        return "添加成功";
    }


    //删除用户
    @RequestMapping("/delete")
    public String delete(Integer id){
        userService.removeById(id);
        return "删除成功";
    }


    //查询用户
    @RequestMapping("/select")
    public List<User> selectAll(){
        return userService.list();
    }


    //通过账号id查询用户信息
    @RequestMapping("/selectByAcountId")
    public User selectByAcountId(Integer acountId){
        LambdaQueryWrapper<User> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(User::getAcountId,acountId);
        return userService.getOne(wrapper);
    }

    //修改用户
    @RequestMapping("/update")
    public String update(@RequestBody User user){
        userService.updateById(user);
        return "修改成功";
    }
}
