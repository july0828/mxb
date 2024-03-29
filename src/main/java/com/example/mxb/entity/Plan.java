package com.example.mxb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
    @TableId(type= IdType.AUTO)
    private Integer id;
    @TableField(value = "user_id")
    private Integer userId;
    private String userName;
    @TableField(value = "doctor_num")
    private Integer doctorNum;
    private String doctorName;
    private String content;
    private String time;
}
