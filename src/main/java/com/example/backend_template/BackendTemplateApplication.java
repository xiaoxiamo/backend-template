package com.example.backend_template;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.backend_template.dao")//使用MapperScan批量扫描所有的Mapper接口；
public class BackendTemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendTemplateApplication.class, args);
    }
}
