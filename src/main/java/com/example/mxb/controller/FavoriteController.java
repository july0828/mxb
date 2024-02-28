package com.example.mxb.controller;

import com.example.mxb.entity.Favorite;
import com.example.mxb.mapper.FavoriteMapper;
import com.example.mxb.service.FavoriteService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteMapper favoriteMapper;

    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/add")
    public String Add(@RequestBody Favorite favorite) {
        favorite.setTime(new Date());
        favoriteService.save(favorite);
        return "添加成功";
    }

    //查询所有知识
    @RequestMapping("/selectAll")
    public List<Favorite> selectAll() {
        List<Favorite> favorites = favoriteService.list();
        return favorites;
    }

    //修改医生
    @RequestMapping("/update")
    public String update(@RequestBody Favorite favorite) {
        favoriteService.saveOrUpdate(favorite);
        return "修改成功";
    }

    //删除医生
    @RequestMapping("/delete")
    public String delete(@RequestBody Favorite favorite) {
        favoriteService.deleteByAccountIdAndAboutId(favorite.getAccountId(), favorite.getAboutId());
        return "删除成功";
    }
}
