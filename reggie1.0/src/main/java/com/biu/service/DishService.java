package com.biu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.biu.dto.DishDto;
import com.biu.entity.Dish;

public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);
}
