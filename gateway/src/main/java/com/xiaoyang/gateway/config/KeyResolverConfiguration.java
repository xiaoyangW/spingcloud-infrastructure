package com.xiaoyang.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 初始化限流的key
 *
 * @author WXY
 */
@Component
public class KeyResolverConfiguration {

    @Bean
    public KeyResolver hostKeyResolver() {
        //使用IP限流
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }


}
