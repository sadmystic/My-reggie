package com.biu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.biu.dto.SetmealDto;
import com.biu.entity.Setmeal;

public interface SetmealService extends IService<Setmeal> {
    //新增套餐，同时保持与菜品的关联关系
    public void saveWithDish(SetmealDto setmealDto);

    public SetmealDto getByIdWithDish(Long id);

    void updateWithDish(SetmealDto setmealDto);
}
