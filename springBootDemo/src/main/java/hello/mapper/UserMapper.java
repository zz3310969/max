package hello.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lenovo on 2017/5/27.
 */
@Mapper
public interface UserMapper {
    @Select("SELECT count(*) FROM i_log WHERE receive_msg = #{receive_msg}")
    Long count(@Param("receive_msg") String receive_msg);

}
