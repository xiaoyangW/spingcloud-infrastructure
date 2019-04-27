package com.xiaoyang.order.controller;

import com.xiaoyang.order.model.Order;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author WXY
 */
@RestController
@RequestMapping("/user/order")
public class OrderController {

    @PostMapping("/add")
    public Mono<Boolean> add(){
        return Mono.just(true);
    }

    @GetMapping("/{id}")
    public Mono<Order> getOrder(@PathVariable("id") Integer id){
        return null;
    }

}
