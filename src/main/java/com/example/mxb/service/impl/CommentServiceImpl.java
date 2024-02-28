package com.example.mxb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mxb.entity.Comment;
import com.example.mxb.entity.Doctor;
import com.example.mxb.mapper.CommentMapper;
import com.example.mxb.mapper.DoctorMapper;
import com.example.mxb.service.CommentService;
import com.example.mxb.service.DoctorService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
