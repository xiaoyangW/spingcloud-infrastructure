package com.xiaoyang.order.controller;

import com.xiaoyang.order.model.Order;
import com.xiaoyang.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author WXY
 */
@RestController
@RequestMapping("/user/order")
public class OrderController {

    private final IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public Mono<Boolean> add( @RequestBody Order order){
        return Mono.just(orderService.addOrder(order));
    }

    @GetMapping("/{id}")
    public Mono<Order> getOrder(@PathVariable("id") Integer id){
        return null;
    }

}
