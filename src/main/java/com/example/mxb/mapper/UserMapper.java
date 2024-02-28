package com.example.mxb.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mxb.entity.Doctor;
import com.example.mxb.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    default User getByAccountId(Integer accountId){
        return selectOne(new LambdaQueryWrapper<User>().eq(User::getAcountId, accountId));
    }
}
