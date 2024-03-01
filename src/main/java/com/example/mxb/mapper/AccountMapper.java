package com.example.mxb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mxb.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    @Insert("insert into account values(null,#{username},#{password},#{role}) ")
    void add(Account account);

    @Select("select * from account where username=#{username} and role = #{role}")
    Account selectByNameAndRole(String username, Integer role);


    @Select("select * from account where id=#{id}")
    Account SelectById(Integer id);



}
