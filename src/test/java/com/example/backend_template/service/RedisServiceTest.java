package com.example.backend_template.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//初始化SpringBoot上下文
@SpringBootTest
class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    //执行所有方法前都要执行的方法
    @BeforeEach
    void setUp() {
    }

    //执行所有方法后都要执行的方法
    @AfterEach
    void tearDown() {
    }

    @Test
    void get() {
        //通过断言测试，不会有提示
        assertNotNull(redisService.get("name"),"未找到该值！");
    }
}