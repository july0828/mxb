package com.example.mxb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mxb.entity.Post;
import com.example.mxb.entity.Reminder;
import com.example.mxb.mapper.PostMapper;
import com.example.mxb.mapper.ReminderMapper;
import com.example.mxb.service.PostService;
import com.example.mxb.service.ReminderService;
import org.springframework.stereotype.Service;

@Service
public class ReminderServiceImpl extends ServiceImpl<ReminderMapper, Reminder> implements ReminderService {
}
