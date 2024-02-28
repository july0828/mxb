package com.example.mxb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mxb.entity.About;
import com.example.mxb.entity.Doctor;
import com.example.mxb.mapper.AboutMapper;
import com.example.mxb.mapper.DoctorMapper;
import com.example.mxb.service.AboutService;
import com.example.mxb.service.DoctorService;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl extends ServiceImpl<AboutMapper, About> implements AboutService {
}
