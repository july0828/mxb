package com.example.mxb.controller;

import com.example.mxb.entity.Account;
import com.example.mxb.entity.Doctor;
import com.example.mxb.entity.User;
import com.example.mxb.mapper.AccountMapper;
import com.example.mxb.service.DoctorService;
import com.example.mxb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AccountController {
    @Autowired
    private AccountMapper mapper;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    //注册
    @RequestMapping("/insert")
    public String add(@RequestBody Account account) {
        String username = account.getUsername();
        Account account1 = mapper.selectByNameAndRole(username, account.getRole());
        if (account1 != null) {
            return "账号已存在,请登录";//账号已存在
        } else {
            mapper.add(account);
            Account account2 = mapper.selectByNameAndRole(username, account.getRole());
            if (account2.getRole() == 2) {//判断是否为医生
                Doctor doctor1 = new Doctor();
                doctor1.setAccountId(account2.getId());//将医生新建的accountid 设置为doctorid
                doctorService.save(doctor1);//存入数据库
            }
            if(account2.getRole()==1){//判断是否为用户
                User user1=new User();
                user1.setAccountId(account2.getId());
                user1.setName(account2.getUsername());//将用户新建的accountid 设置为userid
                userService.save(user1);//存入数据库
            }
            return "注册成功,请登录";//注册成功
        }
    }

    //登录
    @RequestMapping("/login")
    public int login(@RequestBody Account account, HttpSession session) {
        String username = account.getUsername();
        Account account1 = mapper.selectByNameAndRole(username, account.getRole());
        if (account1 != null) {
            if (account1.getPassword().equals(account1.getPassword())) {
                session.setAttribute("account", account1);
                return account1.getRole();//登录成功，返回角色 前台通过角色进入对应的页面
            } else {
                return 400;//密码错误
            }
        } else {
            return 500;//账号不存在
        }
    }

    @RequestMapping("/selectByAccountId")//通过登录去查account
    public Account selectByAccountId(HttpSession session) {
        Account account1 = (Account) session.getAttribute("account");//从登录拿去session account1
        Account account = mapper.selectById(account1.getId());//通过拿去session的ID 去查整个account
        return account;
    }


    @RequestMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }


    @RequestMapping("/userLogin")//预约时判断是否登录并且返回id
    public int userLogin(HttpSession session) {
        Account account1 = (Account) session.getAttribute("account");
        if (account1 == null) {
            return 0;//未登录
        }
        return account1.getId();//登陆成功
    }

    @RequestMapping("/userLoginIndex")//点击后台管理 需要权限判断role
    public int userLoginIndex(HttpSession session) {
        Account account1 = (Account) session.getAttribute("account");
        if (account1 == null) {
            return 0;//未登录
        }
        return account1.getRole();//登陆成功
    }


    @RequestMapping("/userLoginIndex2")//预约时判断是否登录 跳转预约表 判断登录 要是登陆 传入userid
    public Account userLoginIndex2(HttpSession session) {
        Account account1 = (Account) session.getAttribute("account");
        // account1.setPassword("");
        return account1;//登陆成功
    }


}
