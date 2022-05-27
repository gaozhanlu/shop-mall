package com.gzl.uaa.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.uaa.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-05-27
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from sys_user where user_name=#{userName}")
    List<User> selectUser(User userRequest);
}
