package com.example.mxb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mxb.entity.Doctor;
import com.example.mxb.entity.Post;
import com.example.mxb.mapper.DoctorMapper;
import com.example.mxb.mapper.PostMapper;
import com.example.mxb.service.DoctorService;
import com.example.mxb.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
}
