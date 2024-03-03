package com.example.mxb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {
    private final String UPLOAD_DIR = "/Users/ldbmcs/";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = UUID.randomUUID() + fileExtension;
            File targetFile = new File(UPLOAD_DIR + fileName);
            file.transferTo(targetFile);
            return targetFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
    }

    @PostMapping("/delete")
    public String deleteFile(@RequestParam("fileName") String fileName) {
        try {
            File file = new File(UPLOAD_DIR + fileName);
            boolean delete = file.delete();
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
    }
}

