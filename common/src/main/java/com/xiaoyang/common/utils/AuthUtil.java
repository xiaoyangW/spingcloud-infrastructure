package com.xiaoyang.common.utils;

import com.xiaoyang.common.model.User;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.security.Principal;
import java.util.Map;

/**
 *
 */
public class AuthUtil {

    /**
     * 根据principal获取登录用户信息
     *
     * @param principal 登录信息
     * @return User
     */
    public static User getPrincipalUser(OAuth2Authentication principal) {
        if (principal == null) {
            throw new RuntimeException("principal is null");
        }
        Map userMap = (Map) principal.getPrincipal();
        User user = new User();
        BeanMap beanMap = BeanMap.create(user);
        beanMap.putAll(userMap);
        return user;
    }

    /**
     * 获取登录用户id
     *
     * @param principal 用户信息
     * @return user id
     * @author WXY
     */
    public static Integer getPrincipalUserId(Principal principal) {
        if (principal == null) {
            throw new RuntimeException("principal is null");
        }
        Map user = (Map) ((OAuth2Authentication) principal).getPrincipal();
        return (Integer) user.get("id");
    }

}
