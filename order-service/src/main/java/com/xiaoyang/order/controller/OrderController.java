package com.xiaoyang.order.controller;

import com.xiaoyang.common.detail.BaseUserDetails;
import com.xiaoyang.common.model.User;
import com.xiaoyang.common.utils.AuthUtil;
import com.xiaoyang.order.feign.IAuthService;
import com.xiaoyang.order.model.Order;
import com.xiaoyang.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.security.Principal;
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
    @PostMapping("/user")
    public Object user(OAuth2Authentication principal){
        /*User user = AuthUtil.getOAuth2AuthenticationUser(principal);
        log.info("------user info :{}",user.toString());*/
        return principal;
    }

    @PostMapping("/add")
    public Mono<Boolean> add(@RequestBody Order order, Principal principal) {
        log.info("User principal: {}", principal);
        User user = AuthUtil.getPrincipalUser(principal);
        order.setUserId(user.getId());
        return Mono.just(orderService.addOrder(order));
    }

    @GetMapping("/order-info/{id}")
    public Mono<Order> getOrder(@PathVariable("id") Integer id) {
        return null;
    }

}
