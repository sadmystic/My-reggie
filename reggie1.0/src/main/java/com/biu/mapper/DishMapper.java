package com.biu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.biu.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
