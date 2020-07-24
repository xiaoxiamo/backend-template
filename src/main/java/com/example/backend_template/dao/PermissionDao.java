package com.example.backend_template.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName PermissionDao
 * @Description
 * @Author L
 * @Date Create by 2020/6/29
 */
@Mapper
public interface PermissionDao {

    List<Map<String, String>> findRoleAndPermissions();
}
