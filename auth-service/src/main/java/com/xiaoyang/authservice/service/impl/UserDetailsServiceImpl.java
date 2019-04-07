package com.xiaoyang.authservice.service.impl;

import com.xiaoyang.authservice.domain.User;
import com.xiaoyang.authservice.mapper.UserMapper;
import com.xiaoyang.authservice.service.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author xiaoyang.wen
 * @date 2019/3/29 17:01
 */
@Service
public class UserDetailsServiceImpl implements IUserService {

    private final UserMapper userMapper;

    public UserDetailsServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDetails userDetails = userMapper.getUserByName(name);
        if (userDetails == null) {
            throw new UsernameNotFoundException(name);
        }
        return userDetails;
    }

    @Override
    public Boolean addUser(User user) {
        if (user != null) {
            user.setPsw(new BCryptPasswordEncoder().encode(user.getPassword()));
            return userMapper.addUser(user) > 0;
        }
        return false;
    }
}
