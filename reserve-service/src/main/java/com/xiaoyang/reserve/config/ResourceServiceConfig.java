package com.xiaoyang.reserve.config;

import feign.RequestInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {


    @Bean
    @Order(1)
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    @Order(2)
    public RequestInterceptor requestInterceptor(ClientCredentialsResourceDetails clientCredentialsResourceDetails) {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails);
    }

    @Bean
    @Order(2)
    public OAuth2RestTemplate oAuth2RestTemplate(ClientCredentialsResourceDetails clientCredentialsResourceDetails) {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails);
    }
}
