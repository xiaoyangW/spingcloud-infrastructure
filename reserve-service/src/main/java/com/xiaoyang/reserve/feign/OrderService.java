package com.xiaoyang.reserve.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author WXY
 */

@Repository
@FeignClient(name = "order-service")
public interface OrderService {

    @RequestMapping(method = RequestMethod.POST, value = "/order/order/user")
    Object user();

}
