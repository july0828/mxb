package com.example.mxb.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mxb.entity.Favorite;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FavoriteMapper extends BaseMapper<Favorite> {

    default List<Favorite> selectByUserId(Integer userId){
        return selectList(new LambdaQueryWrapper<Favorite>().eq(Favorite::getAccountId,userId));
    }
}
