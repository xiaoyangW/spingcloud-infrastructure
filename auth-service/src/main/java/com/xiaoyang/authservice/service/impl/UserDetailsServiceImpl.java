package com.xiaoyang.authservice.service.impl;


import com.xiaoyang.authservice.domain.BaseUserDetails;
import com.xiaoyang.authservice.mapper.UserMapper;
import com.xiaoyang.authservice.service.IUserService;
import com.xiaoyang.common.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author xiaoyang.wen
 * @date 2019/3/29 17:01
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements IUserService {

    private final UserMapper userMapper;

    public UserDetailsServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userMapper.getUserByName(name);
        log.info("loadUserByUsername:{}", user);
        user.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority("admin_user")));
        if (user == null) {
            throw new UsernameNotFoundException(name);
        }
        return new BaseUserDetails(user);
    }

    @Override
    public Boolean addUser(User user) {
        if (user != null) {
            user.setPsw(new BCryptPasswordEncoder().encode(user.getPsw()));
            return userMapper.addUser(user) > 0;
        }
        return false;
    }
}
