package com.example.mxb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    @TableId(type= IdType.AUTO)
    private Integer id;
    //高压
    private Integer bloodpressureup;
    //低压
    private Integer bloodpressuredown;
    //血糖
    private Float bloodsugar;
    //身高
    private Float height;
    //体重
    private Float weight;
    //心率
    private Float rate;
    //时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date time;

    //运动状况
    private Float exercise;
    //血脂
    private Float lipid;
    //睡眠情况
    private Float sleep;
    //体温情况
    private Float temperature;
    //名字
    private String name;


}
