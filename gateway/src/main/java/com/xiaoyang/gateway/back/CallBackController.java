package com.xiaoyang.gateway.back;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WXY
 */
@Slf4j
@RestController
public class CallBackController {

    @RequestMapping("/fallback")
    public Mono<Map> fallBack() {
        Map<String, String> map = new HashMap<>(2);
        map.put("code", "1001");
        map.put("msg", "error");
        log.info("......gateway fallback......");
        return Mono.just(map);
    }


}
