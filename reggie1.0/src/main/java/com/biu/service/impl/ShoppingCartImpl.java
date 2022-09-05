package com.biu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biu.entity.ShoppingCart;
import com.biu.mapper.ShoppingCartMapper;
import com.biu.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
