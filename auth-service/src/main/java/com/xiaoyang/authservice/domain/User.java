package com.xiaoyang.authservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author WXY
 * @date 2018/8/3 18:54
 */
@Setter
@Getter
@ToString
public class User {

    private String name;
    private String psw;
    private String emil;
    private String mobile;
    private String createTime;

}
