package com.example.mxb.mapper;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mxb.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {

@Update("update doctor set num=#{num},grade=#{grade},category=#{category},sex=#{sex},phone=#{phone},photo=#{photo},brief=#{brief},name=#{name} " +
        "where acount_id=#{acountId}")
    public void updateDoctor(Doctor doctor);
}


