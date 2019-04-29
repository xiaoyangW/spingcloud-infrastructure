package com.xiaoyang.common.utils;

import com.xiaoyang.common.detail.BaseUserDetails;
import com.xiaoyang.common.model.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.security.Principal;

/**
 * @author WXY
 */
public class AuthUtil {

    /**
     * 根据principal获取登录用户信息
     *
     * @param principal 登录信息
     * @return User
     */
    public static User getPrincipalUser(Principal principal) {
        if (principal == null) {
            throw new RuntimeException("principal is null");
        }
        return ((BaseUserDetails) principal).getUser();
    }

    /**
     * 根据OAuth2Authentication获取登录用户信息ss
     *
     * @param oAuth2Authentication OAuth2Authentication
     * @return User
     */
    public static User getOAuth2AuthenticationUser(OAuth2Authentication oAuth2Authentication) {
        if (oAuth2Authentication == null) {
            throw new RuntimeException("OAuth2Authentication is null");
        }
        return ((BaseUserDetails) oAuth2Authentication.getPrincipal()).getUser();
    }

}
