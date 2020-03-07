package com.xiaoyang.authservice.controller;

import com.xiaoyang.authservice.domain.BaseUserDetails;
import com.xiaoyang.authservice.service.IUserService;
import com.xiaoyang.common.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author WXY
 * @date 2019/4/3 20:39
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user-info")
    public Object userInfo(OAuth2Authentication principal) {
        return principal.getPrincipal();//((BaseUserDetails)principal.getPrincipal()).getUser();
    }

    @GetMapping("/principal")
    public User getUser(OAuth2Authentication auth2Authentication) {
        BaseUserDetails userDetails = (BaseUserDetails) auth2Authentication.getPrincipal();
        return userDetails.getUser();
    }

    @PostMapping("/add")
    public Mono<Boolean> addUser(@RequestBody User user) {
        return Mono.just(userService.addUser(user));
    }

}
