package com.biu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biu.entity.OrderDetail;
import com.biu.mapper.OrderDetailMapper;
import com.biu.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 *
 * @author anyi
 * @since 2022-05-25
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}