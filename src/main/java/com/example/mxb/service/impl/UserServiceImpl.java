package com.example.mxb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mxb.entity.Doctor;
import com.example.mxb.entity.User;
import com.example.mxb.mapper.DoctorMapper;
import com.example.mxb.mapper.UserMapper;
import com.example.mxb.service.DoctorService;
import com.example.mxb.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
