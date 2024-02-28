package com.example.mxb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mxb.entity.Announce;
import com.example.mxb.entity.Appointment;
import com.example.mxb.mapper.AnnounceMapper;
import com.example.mxb.mapper.AppointmentMapper;
import com.example.mxb.service.AnnounceService;
import com.example.mxb.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AnnounceServiceImpl extends ServiceImpl<AnnounceMapper, Announce> implements AnnounceService {
}
