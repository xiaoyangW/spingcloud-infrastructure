package com.xiaoyang.authservice.service;

import com.xiaoyang.common.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author WXY
 * @date 2019/4/3 21:20
 */

public interface IUserService extends UserDetailsService {

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return boolean true
     */
    Boolean addUser(User user);

}
