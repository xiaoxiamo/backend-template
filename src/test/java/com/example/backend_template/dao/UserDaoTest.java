package com.example.backend_template.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//初始化SpringBoot上下文
@SpringBootTest
//提供事务功能
@Transactional
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    //执行所有方法前都要执行的方法
    @BeforeEach
    void setUp() {
    }

    //执行所有方法后都要执行的方法
    @AfterEach
    void tearDown() {
    }

    @Test
    void findByUsername() {
        //通过断言测试，不会有提示
        assertNotNull(userDao.findByUsername("user"),"未找到该用户！");
    }
}