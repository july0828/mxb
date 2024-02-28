package com.example.mxb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mxb.entity.About;
import com.example.mxb.entity.Favorite;
import com.example.mxb.mapper.AboutMapper;
import com.example.mxb.mapper.FavoriteMapper;
import com.example.mxb.service.AboutService;
import com.example.mxb.service.FavoriteService;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite> implements FavoriteService {
}
