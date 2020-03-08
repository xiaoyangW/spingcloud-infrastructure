package com.xiaoyang.order.controller;

import com.xiaoyang.common.model.User;
import com.xiaoyang.common.utils.AuthUtil;
import com.xiaoyang.order.feign.IAuthService;
import com.xiaoyang.order.model.Order;
import com.xiaoyang.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author WXY
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderService;
    private final IAuthService authService;

    @Autowired
    public OrderController(IOrderService orderService, IAuthService authService) {
        this.orderService = orderService;
        this.authService = authService;
    }

    @PostMapping("/test")
    public Object user() {
        OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        User principalUser = AuthUtil.getPrincipalUser(authentication);
        log.info(" request user:{}",principalUser);
        return authService.test();
    }

    @PostMapping("/add")
    public Mono<Boolean> add(@RequestBody Order order, OAuth2Authentication principal) {
        log.info("User principal: {}", principal);
        Map user = (Map) principal.getPrincipal();
        order.setUserId((Integer) user.get("id"));
        return Mono.just(orderService.addOrder(order));
    }

    @GetMapping("/order-info/{id}")
    public Mono<Order> getOrder(@PathVariable("id") Integer id) {
        return null;
    }

}
