package com.example.backend_template.security;

import com.example.backend_template.dao.RoleDao;
import com.example.backend_template.dao.UserDao;
import com.example.backend_template.entity.Role;
import com.example.backend_template.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserDetailsService
 * @Description
 * @Author L
 * @Date Create by 2020/6/29
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查数据库，查找到用户名对应的所有角色，并注入user中
        User user = userDao.findByUsername(userName);
        if (user != null) {
            List<Role> roles = roleDao.findByUserId(user.getId());
            user.setAuthorities(roles);
        }
        return user;
    }
}