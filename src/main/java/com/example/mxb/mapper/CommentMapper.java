package com.example.mxb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mxb.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
