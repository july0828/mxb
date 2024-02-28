package com.example.mxb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mxb.entity.Information;
import com.example.mxb.entity.Post;
import com.example.mxb.mapper.InformationMapper;
import com.example.mxb.mapper.PostMapper;
import com.example.mxb.service.InformationService;
import com.example.mxb.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information> implements InformationService {
}