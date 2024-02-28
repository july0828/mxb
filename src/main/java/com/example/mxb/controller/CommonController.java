package com.example.mxb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@RestController
@RequestMapping("/common")
public class CommonController {
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
}
