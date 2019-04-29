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
    /**
     * 根据用户名查询用户
     * @param name 用户name
     * @return User Info
     */
    @Select("select id, name,psw,emil,mobile,create_time createTime from user where name=#{name}")
    User getUserByName(String name);

    /**
     * 添加用户
     * @param user 用户信息
     * @return Int
     */
    @Insert("insert into user(name,psw,emil,mobile,create_time) values (#{name},#{psw},#{emil},#{mobile},#{createTime})")
    Integer addUser(User user);

}
