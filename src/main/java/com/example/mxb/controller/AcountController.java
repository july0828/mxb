package com.example.mxb.controller;

import com.example.mxb.entity.Acount;
import com.example.mxb.entity.Doctor;
import com.example.mxb.entity.User;
import com.example.mxb.mapper.AcountMapper;
import com.example.mxb.service.DoctorService;
import com.example.mxb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AcountController {
    @Autowired
    private AcountMapper mapper;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    //注册
    @RequestMapping("/insert")
    public String add(@RequestBody Acount acount) {
        String username = acount.getUsername();
        Acount acount1 = mapper.selectByNameAndRole(username, acount.getRole());
        if (acount1 != null) {
            return "账号已存在,请登录";//账号已存在
        } else {
            mapper.add(acount);
            Acount acount2 = mapper.selectByNameAndRole(username, acount.getRole());
            if (acount2.getRole() == 2) {//判断是否为医生
                Doctor doctor1 = new Doctor();
                doctor1.setAcountId(acount2.getId());//将医生新建的acountid 设置为doctorid
                doctorService.save(doctor1);//存入数据库
            }
            if(acount2.getRole()==1){//判断是否为用户
                User user1=new User();
                user1.setAcountId(acount2.getId());
                user1.setName(acount2.getUsername());//将用户新建的acountid 设置为userid
                userService.save(user1);//存入数据库
            }
            return "注册成功,请登录";//注册成功
        }
    }

    //登录
    @RequestMapping("/login")
    public int login(@RequestBody Acount acount, HttpSession session) {
        String username = acount.getUsername();
        Acount acount1 = mapper.selectByNameAndRole(username, acount.getRole());
        if (acount1 != null) {
            if (acount1.getPassword().equals(acount1.getPassword())) {
                session.setAttribute("acount", acount1);
                return acount1.getRole();//登录成功，返回角色 前台通过角色进入对应的页面
            } else {
                return 400;//密码错误
            }
        } else {
            return 500;//账号不存在
        }
    }

    @RequestMapping("/selectByAcountId")//通过登录去查acount
    public Acount selectByAcountId(HttpSession session) {
        Acount acount1 = (Acount) session.getAttribute("acount");//从登录拿去session acount1
        Acount acount = mapper.selectById(acount1.getId());//通过拿去session的ID 去查整个acount
        return acount;
    }


    @RequestMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }


    @RequestMapping("/userLogin")//预约时判断是否登录并且返回id
    public int userLogin(HttpSession session) {
        Acount acount1 = (Acount) session.getAttribute("acount");
        if (acount1 == null) {
            return 0;//未登录
        }
        return acount1.getId();//登陆成功
    }

    @RequestMapping("/userLoginIndex")//点击后台管理 需要权限判断role
    public int userLoginIndex(HttpSession session) {
        Acount acount1 = (Acount) session.getAttribute("acount");
        if (acount1 == null) {
            return 0;//未登录
        }
        return acount1.getRole();//登陆成功
    }


    @RequestMapping("/userLoginIndex2")//预约时判断是否登录 跳转预约表 判断登录 要是登陆 传入userid
    public Acount userLoginIndex2(HttpSession session) {
        Acount acount1 = (Acount) session.getAttribute("acount");
        // acount1.setPassword("");
        return acount1;//登陆成功
    }


}
