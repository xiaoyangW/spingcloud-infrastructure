package com.xiaoyang.business.controller;

import com.xiaoyang.business.feign.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@RequestMapping("/test")
public class TestController {

    private final IAuthService authService;

    @Autowired
    public TestController(IAuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/principal")
    public Principal getUser(Principal principal){
        return principal;
    }

    @GetMapping("/test")
    public Mono<String> test(){
        return Mono.just("sssss");
    }
}
