package com.xiaoyang.authservice.mapper;

import com.xiaoyang.authservice.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author WXY
 * @date 2018/8/3 18:47
 */
@Mapper
@Repository
public interface UserMapper {

    @Select("select name,psw from user where name=#{name}")
    User getUserByName(String name);

    @Insert("insert into user(name,psw) values (#{name},#{psw})")
    void addUser(User user);

}
