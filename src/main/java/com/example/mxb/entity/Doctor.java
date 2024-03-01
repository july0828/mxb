package com.example.mxb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer num;
    private String grade;
    private String sex;
    private String phone;
    private String photo;
    @TableField(value = "account_id")
    private Integer accountId;
    private String brief;
    private String category;
    private String name;
}
