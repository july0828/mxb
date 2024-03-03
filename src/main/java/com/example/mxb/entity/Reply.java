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
public class Reply {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //用户id
    private Integer accountId;
    //医生工号
    private Integer doctorNum;
    //问题id
    private Integer questionId;
    //医生姓名
    private String doctorName;
    //用户姓名
    private String userName;
    //问题内容
    private String questionContent;
    //回复内容
    private String replyContent;
    //咨询时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date questionTime;
    //回复时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date replyTime;
}
