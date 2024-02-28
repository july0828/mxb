package com.example.mxb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mxb.entity.Doctor;
import com.example.mxb.mapper.AcountMapper;
import com.example.mxb.mapper.DoctorMapper;
import com.example.mxb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/doctor")
@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Resource
    private DoctorMapper doctorMapper;

    //添加医生
    @RequestMapping("/insert")
    public String insert(@RequestBody Doctor doctor){
       doctorMapper.updateDoctor(doctor);
        return "添加成功";
    }

    @RequestMapping("/upload")
    public String Add(MultipartFile picFile) throws IOException {
        //获取原文件名 a.jpg
        String filename = picFile.getOriginalFilename();

        System.out.println("文件名：" + filename);
        //获取文件后缀
        String suf = filename.substring(filename.lastIndexOf("."));
        //获取唯一取文件名 UUID
        filename = UUID.randomUUID() + suf;
        //获取文件保存地址（文件夹）
        String dirpath = "D:/files/mxb";
        File path = new File(dirpath);
        //判断文件是否存在；如果不存在创建此文件夹
        if (!path.exists()) {
            path.mkdir();
        }
        String path1 = path + "/" + filename;
        picFile.transferTo(new File(path1));
        return filename;
    }

    //查询所有医生
    @RequestMapping("/selectAll")
    public List<Doctor> selectAll(){
        List<Doctor> doctors=doctorService.list();
        return doctors;
    }

    // //查询所有医生
    // @RequestMapping("/selectAllById")
    // public Doctor selectAllById(Integer id){
    //     Doctor doctor=doctorService.getById(id);
    //     return doctor;
    // }

    //修改医生
    @RequestMapping("/update")
    public String update(@RequestBody Doctor doctor){
        doctorService.saveOrUpdate(doctor);
        return "修改成功";
    }

    //删除医生
    @RequestMapping("/delete")
    public String delete(Integer id){
        doctorService.removeById(id);
        return "删除成功";
    }

    //通过医生num查询医生对象
    @RequestMapping("/selectByNum")
    public Doctor selectByNum(Integer num){
        LambdaQueryWrapper<Doctor> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(Doctor::getNum,num);
        return doctorService.getOne(wrapper);
    }
}
