package com.example.mxb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mxb.entity.Acount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AcountMapper extends BaseMapper<Acount> {
    @Insert("insert into acount values(null,#{username},#{password},#{role}) ")
    void add(Acount acount);

    @Select("select * from acount where username=#{username} and role = #{role}")
    Acount selectByNameAndRole(String username, Integer role);


    @Select("select * from acount where id=#{id}")
    Acount SelectById(Integer id);



}
