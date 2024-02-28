package com.example.mxb.controller;

import com.example.mxb.entity.Banner;
import com.example.mxb.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/banner")
@RestController
public class BannerController {
    @Autowired
    private BannerService bannerService;



    @RequestMapping("/insert")
    public String insert(@RequestBody Banner banner) {
        bannerService.save(banner);
        return "添加成功";
    }

    @RequestMapping("/selectAll")
    public List<Banner> selectAll() {
        List<Banner> list = bannerService.list();
        return list;
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        bannerService.removeById(id);
        return "删除成功";
    }


    @RequestMapping("/update")
    public String update(@RequestBody Banner banner){
        bannerService.updateById(banner);
        return "修改成功";
    }
}
