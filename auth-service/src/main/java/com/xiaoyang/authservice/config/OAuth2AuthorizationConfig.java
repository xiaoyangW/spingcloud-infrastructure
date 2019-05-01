package com.xiaoyang.authservice.config;

import com.xiaoyang.authservice.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 服务端点配置 认证管理器，token存储管理，用户信息
 *
 * @author xiaoyang.wen
 * @date 2019/3/29 16:10
 */
@Configuration
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

    private final UserDetailsServiceImpl userDetailsService;

    private TokenStore tokenStore;


    public OAuth2AuthorizationConfig(@Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, RedisConnectionFactory redisConnectionFactory) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.tokenStore = new InMemoryTokenStore();//new RedisTokenStore(redisConnectionFactory);
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        clients.inMemory()
                .withClient("browser")
                .authorizedGrantTypes("refresh_token", "password")
                .scopes("ui")
                .and()
                .withClient("order-service")
                .authorizedGrantTypes("refresh_token", "client_credentials")
                .secret(passwordEncoder.encode("82cd04e2-72a6-4171-b738-c03f5b41560e"))
                .scopes("server")
                .and()
                .withClient("reserve-service")
                .authorizedGrantTypes("refresh_token", "client_credentials")
                .secret(passwordEncoder.encode("11be4f67-dce9-489a-bc0d-83b4a2b1d0c1"))
                .scopes("server");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                .userDetailsService(userDetailsService);
    }

    /**
     * 服务端安全配置
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                //开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("isAuthenticated()")
                .passwordEncoder(new BCryptPasswordEncoder())
                .allowFormAuthenticationForClients();
    }
}
