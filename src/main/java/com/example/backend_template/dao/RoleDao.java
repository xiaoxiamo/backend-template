package com.example.backend_template.dao;

import com.example.backend_template.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ClassName RoleDao
 * @Description
 * @Author L
 * @Date Create by 2020/6/28
 */
@Mapper
public interface RoleDao {
    /**
     * 通过用户ID查找用户角色
     *
     * @param userId
     * @return
     */
    List<Role> findByUserId(@Param("userId") Long userId);
}