package com.example.backend_template.dao;

import com.example.backend_template.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UserDao
 * @Description
 * @Author L
 * @Date Create by 2020/6/28
 */
@Mapper
public interface UserDao {
    /**
     * 通过用户名加载用户
     *
     * @param userName
     * @return
     */
    User findByUsername(@Param("userName") String userName);
}