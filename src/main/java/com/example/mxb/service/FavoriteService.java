package com.example.mxb.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mxb.entity.Favorite;
import org.springframework.stereotype.Service;

@Service
public interface FavoriteService extends IService<Favorite> {
    default void deleteByAccountIdAndAboutId(Integer accountId, Integer aboutId) {
        remove(new LambdaQueryWrapper<Favorite>().eq(Favorite::getAccountId, accountId).eq(Favorite::getAboutId, aboutId));
    }
}
