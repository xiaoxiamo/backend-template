### 简介
一个基于 Spring Boot 的后端开发模板，主要用于减少平时重复的工作量，以及使开发有良好的开发规范，主要功能包括但不限于**权限管理**、**在线接口文档**、**日志记录**、**单元测试**、**统一异常**、**自动生成代码**、**数据校验**、**数据库版本控制**等。
### 目录
##### [一、初始化Spring Boot项目](https://blog.csdn.net/qq_22136439/article/details/107464935)
##### [二、整合 mybatis 、Druid连接池、PageHelper分页](https://blog.csdn.net/qq_22136439/article/details/107465401)
##### [三、整合Redis](https://blog.csdn.net/qq_22136439/article/details/107465623)
##### [四、整合 Spring Security](https://blog.csdn.net/qq_22136439/article/details/107465834)
##### [五、整合Swagger2](https://blog.csdn.net/qq_22136439/article/details/107466247)
##### [六、统一请求结果格式](https://blog.csdn.net/qq_22136439/article/details/107466974)
##### [七、代码自动生成](https://blog.csdn.net/qq_22136439/article/details/107467113)
##### [八、全局统一异常处理](https://blog.csdn.net/qq_22136439/article/details/107467519)
##### [九、单元测试](https://blog.csdn.net/qq_22136439/article/details/107467769)
##### [十、数据校验](https://blog.csdn.net/qq_22136439/article/details/107468127)
##### [十一、统一日志规范](https://blog.csdn.net/qq_22136439/article/details/107566953)
##### [十二、数据库版本控制](https://blog.csdn.net/qq_22136439/article/details/107630571)
### 特征&技术选型
- 最佳实践的项目结构、配置文件
- 整合MyBatis、Druid连接池、PageHelper分页插件
- redis 缓存功能
- Spring Security 权限管理
- Swagger2 在线生成接口文档
- 统一响应结果封装
- 自动生成基础代码
- 全局统一异常处理
- Spring Junit 5单元测试
- 数据校验
- 统一日志规范
- 数据库版本控制
### 项目环境
- jdk 1.8
- maven 4.0.0
- spring boot 2.3.1
- mysql 8.0
- druid 1.1.10
- mybatis 2.1.0
- pagehelper 1.2.5
- swagge 2 2.7
- redis 3.0
- IDEA 2019.3
- JUnit 5.6
- hibernate-validator 6.1.0
- flyway 6.5.0
### 运行
除了以上的环境要有外，还要改配置文件为自己的设置，最后还需要数据库，数据库SQL文件在resources\db\migration目录下，当然最好的方式，还是和**目录**上的博客自己过一次
```
mysql -uroot -p backend_template < V20200729.16.00.00__V1.0_Init_Database.sql
```
### 其它
如果做到哪步有问题的，可以提出来，我会尽我所能回答。如果有更好的模板代替方案，也希望大佬提出来，相互学习，共同进步！**关注**、**收藏**、**点赞**不迷路哦
