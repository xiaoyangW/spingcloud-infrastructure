package com.xiaoyang.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

/**
 * @author WXY
 */


@Configuration
public class RoutesConfiguration {
    /**
     * 代码配置路由
     */
    /*@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("order-service", predicateSpec ->
                predicateSpec.path("/order/**")
                        .and().asyncPredicate(initTokenRoutePredicateFactory().applyAsync(config -> config.setHeaderName("Authorization")))
                        .uri("lb://order-service")
                .filters()
        ).build();
    }*/

    @Bean
    public TokenRoutePredicateFactory initTokenRoutePredicateFactory() {
        return new TokenRoutePredicateFactory();
    }

}
