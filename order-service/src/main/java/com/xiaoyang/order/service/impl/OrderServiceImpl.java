package com.xiaoyang.order.service.impl;

import com.xiaoyang.order.mapper.OrderMapper;
import com.xiaoyang.order.model.Order;
import com.xiaoyang.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author WXY
 */
@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Boolean addOrder(Order order) {
        if (order != null) {
            return orderMapper.addOrder(order) > 0;
        }
        return false;
    }
}
