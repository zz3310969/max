package org.max.web.role.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.max.web.role.entity.BaseRole;
import org.max.web.role.entity.Role;

import java.util.Set;

/**
 * Created by lenovo on 2017/5/31.
 */
@Mapper
public interface IRoleDao {
    @Select("select * from s_role where id = #{id}")
    BaseRole load(Class<Role> roleClass, Long roleId);
    @Select("select * from s_role where id = #{id}")
    Set<?> selectByUser(Long id);
}
