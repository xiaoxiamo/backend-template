package com.example.backend_template.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//初始化SpringBoot上下文
@SpringBootTest
class RedisControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).alwaysDo(print()).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setRedis() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/redis/setRedis").content("L");
        mockMvc.perform(request).andExpect(status().isOk()).andDo(print());
    }

    @Test
    void getRedis() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/redis/getRedis");
        mockMvc.perform(request).andExpect(status().isOk()).andDo(print());
    }
}