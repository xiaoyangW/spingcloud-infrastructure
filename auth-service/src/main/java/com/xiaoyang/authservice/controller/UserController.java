package com.xiaoyang.authservice.controller;

import com.xiaoyang.authservice.domain.User;
import com.xiaoyang.authservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.security.Principal;

/**
 * @author WXY
 * @date 2019/4/3 20:39
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/principal")
    public Principal getUser(Principal principal){
        return principal;
    }

    @PostMapping("/add")
    public Mono<Boolean> addUser(@RequestBody User user){
        return Mono.just(userService.addUser(user));
    }

}
