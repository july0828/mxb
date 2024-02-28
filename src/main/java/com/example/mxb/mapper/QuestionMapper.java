package com.example.mxb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mxb.entity.Question;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}
