package com.example.mxb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mxb.entity.Appointment;
import com.example.mxb.entity.Banner;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BannerMapper extends BaseMapper<Banner> {
}
