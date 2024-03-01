package com.example.mxb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 15209
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String type;
    private String phone;
    private String address;
    @TableField(value = "account_id")
    private Integer accountId;
    @TableField(value = "id_card")
    private Integer idCard;
}
