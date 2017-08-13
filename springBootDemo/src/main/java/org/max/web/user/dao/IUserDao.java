package org.max.web.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.max.web.user.entity.User;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/5/31.
 */
@Mapper
public interface IUserDao {
    @Select("select * from s_user where username = #{username}")
    User loadUserByUsername(String username);
    @Select("select * from s_user where id = #{id}")
    <T> T load(Class<T> entityClass, Serializable id);
}
