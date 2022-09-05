package com.biu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.biu.entity.Orders;


public interface OrdersService extends IService<Orders> {

    void submit(Orders orders);

    //Page<OrdersDto> userPage(Integer page, Integer pageSize);
}