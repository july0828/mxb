package com.example.mxb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mxb.entity.Banner;
import com.example.mxb.mapper.BannerMapper;
import com.example.mxb.mapper.DoctorMapper;
import com.example.mxb.service.BannerService;
import com.example.mxb.service.DoctorService;
import org.springframework.stereotype.Service;


@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {
}
