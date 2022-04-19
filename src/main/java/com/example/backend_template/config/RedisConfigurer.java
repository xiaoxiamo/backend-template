package com.example.backend_template.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName RedisConfigurer Redis的配置类
 * @Description
 * @Author L
 * @Date Create by 2020/6/26
 */
@Configuration
@EnableCaching      //开启缓存
public class RedisConfigurer extends CachingConfigurerSupport {

    /**
     * redis 的各种配置信息，由框架注入
     */
    @Autowired
    private RedisProperties redisProperties;

    /**
     * 日志工具
     */
    private static final Logger log = LoggerFactory.getLogger(RedisConfigurer.class);

    @Bean
    public JedisConnectionFactory getConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration =
                new RedisStandaloneConfiguration(redisProperties.getHost(), redisProperties.getPort());
        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration);
        log.info("The hostname of the redis connection is：{}, and the port is: {}", factory.getHostName(), factory.getPort());
        return factory;
    }

    public RedisTemplate<?, ?> getRedisTemplate() {
        RedisTemplate<?, ?> template = new StringRedisTemplate(getConnectionFactory());
        return template;
    }
}