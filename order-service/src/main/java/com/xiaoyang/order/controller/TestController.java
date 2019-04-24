package com.xiaoyang.order.controller;

import com.xiaoyang.order.feign.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

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
    public Mono<Boolean> test(){
        Map<String, String> user = new HashMap<>(2);
        user.put("name","user1");
        user.put("psw",new BCryptPasswordEncoder().encode("123456"));
        return Mono.just(authService.add(user));
    }
}
