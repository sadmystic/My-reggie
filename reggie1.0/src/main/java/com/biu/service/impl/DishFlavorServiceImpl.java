package com.biu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biu.entity.DishFlavor;
import com.biu.mapper.DishFlavorMapper;
import com.biu.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}