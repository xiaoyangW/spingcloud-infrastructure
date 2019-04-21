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
public class User implements UserDetails {

    private String name;
    private String psw;
    private String emil;
    private String mobile;
    private String createTime;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return psw;
    }

    @Override
    public String getUsername() {
        return name;
    }

    /**
     * 用户是否过期
     * @return Boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户是否锁定
     * @return boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 证书未过期
     * @return boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
