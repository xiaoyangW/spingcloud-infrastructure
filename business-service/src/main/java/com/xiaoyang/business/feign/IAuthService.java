package com.xiaoyang.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Repository
@FeignClient(name = "auth-service")
public interface IAuthService {

    @RequestMapping(method = RequestMethod.GET,value = "/user/principal")
    Principal getUser();

}
