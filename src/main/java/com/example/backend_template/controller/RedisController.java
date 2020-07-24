package com.example.backend_template.controller;

import com.example.backend_template.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName RedisController
 * @Description
 * @Author L
 * @Date Create by 2020/6/26
 */
@Api(tags = "redis简单测试接口")
@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    private RedisService redisService;

    private static final Logger log = LoggerFactory.getLogger(RedisController.class);

    @ApiOperation("向redis中存储`name`值")
    @ApiImplicitParam(name = "name", value = "名称值", defaultValue = "L", required = true)
    @PostMapping("/setRedis")
    public Boolean setRedis(@RequestBody String name) {
        log.info("The name value stored in Redis is: {}", name);
        return redisService.set("name", name);
    }

    @ApiOperation("向redis中取`name`值")
    @GetMapping("/getRedis")
    public String getRedis() {
        String name = redisService.get("name");
        log.info("The name value obtained from Redis is: {}", name);
        return name;
    }
}