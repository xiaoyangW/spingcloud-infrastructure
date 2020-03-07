package com.xiaoyang.order.feign;

import com.xiaoyang.common.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Map;

@Repository
@FeignClient(name = "auth-service")
public interface IAuthService {

    @RequestMapping(method = RequestMethod.GET, value = "/auth/user/principal")
    Map<String,Object> getUser();

    @RequestMapping(method = RequestMethod.POST, value = "/auth/user/add")
    Boolean add(@RequestBody Map<String, String> user);
    @RequestMapping(method = RequestMethod.GET, value = "/auth/user/test")
    String test();
}
