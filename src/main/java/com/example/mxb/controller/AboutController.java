package com.example.mxb.controller;

import com.example.mxb.entity.*;
import com.example.mxb.mapper.AboutMapper;
import com.example.mxb.mapper.FavoriteMapper;
import com.example.mxb.mapper.UserMapper;
import com.example.mxb.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/about")
public class AboutController {
    @Autowired
    private AboutMapper aboutMapper;

    @Autowired
    private AboutService aboutService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FavoriteMapper favoriteMapper;

    @RequestMapping("/add")
    public String Add(@RequestBody About about){
        about.setTime(new Date());
        aboutService.save(about);
        return "添加成功";
    }

    //查询所有知识
    @RequestMapping("/selectAll")
    public List<About> selectAll(HttpSession session){
        List<About> abouts=aboutService.list();
        Acount acount = (Acount) session.getAttribute("acount");
        List<Favorite> favorites = favoriteMapper.selectByAccountId(acount.getId());
        List<Integer> aboutIds = favorites.stream().map(Favorite::getAboutId).collect(Collectors.toList());
        abouts.forEach(about -> about.setIsFavorite(aboutIds.contains(about.getId())));
        return abouts;
    }

    //修改医生
    @RequestMapping("/update")
    public String update(@RequestBody About about){
        aboutService.saveOrUpdate(about);
        return "修改成功";
    }

    //删除医生
    @RequestMapping("/delete")
    public String delete(Integer id){
       aboutService.removeById(id);
        return "删除成功";
    }
}
