package com.biu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biu.dto.SetmealDto;
import com.biu.entity.Setmeal;
import com.biu.entity.SetmealDish;
import com.biu.mapper.SetmealMapper;
import com.biu.service.SetmealDishService;
import com.biu.service.SetmealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

    @Autowired
    private SetmealDishService setmealDishService;

    //新增套餐，同时保持与菜品的关联关系
    @Override
    @Transactional
    public void saveWithDish(SetmealDto setmealDto){
        //保存套餐基本信息,操作setmeal，执行insert操作
        this.save(setmealDto);

        List<SetmealDish> setmealDishes=setmealDto.getSetmealDishes();

        setmealDishes.stream().map((item)->{
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());

        //保存套餐和菜品的关联信息，操作setmeal_dish,执行insert操作
        setmealDishService.saveBatch(setmealDishes);

    }

    @Override
    public SetmealDto getByIdWithDish(Long id) {
        //查询套餐基本信息
        SetmealDto setmealDto=new SetmealDto();
        Setmeal setmeal=this.getById(id);
        BeanUtils.copyProperties(setmeal,setmealDto);

        LambdaQueryWrapper<SetmealDish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getSetmealId,setmeal.getId());
        List<SetmealDish> list=setmealDishService.list(queryWrapper);

        setmealDto.setSetmealDishes(list);
        return setmealDto;
    }

    @Override
    public void updateWithDish(SetmealDto setmealDto){
        //更新Setmeal表
        this.updateById(setmealDto);

        //更新SetmealDish表delete
        LambdaQueryWrapper<SetmealDish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getSetmealId,setmealDto.getId());
        setmealDishService.remove(queryWrapper);

        //更新SetmealDish表的insert
        List<SetmealDish> SetmealDishes=setmealDto.getSetmealDishes();

        SetmealDishes=SetmealDishes.stream().map((item)->{
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());

        setmealDishService.saveBatch(SetmealDishes);
    }

}
