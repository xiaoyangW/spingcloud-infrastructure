package com.xiaoyang.authservice.service;

import com.xiaoyang.authservice.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author WXY
 * @date 2019/4/3 21:20
 */

public interface IUserService extends UserDetailsService {

    Boolean addUser(User user);

}
