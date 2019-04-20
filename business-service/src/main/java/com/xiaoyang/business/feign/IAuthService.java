package com.xiaoyang.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.Map;

@Repository
@FeignClient(name = "auth-service")
public interface IAuthService {

    @RequestMapping(method = RequestMethod.GET,value = "/user/principal")
    Principal getUser();

    @RequestMapping(method = RequestMethod.POST,value = "/user/add")
    Boolean add(@RequestBody Map<String,String> user);
}
