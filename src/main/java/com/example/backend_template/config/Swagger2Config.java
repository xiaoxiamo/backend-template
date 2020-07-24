package com.example.backend_template.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName Swagger2Config swagger的配置内容即是创建一个Docket实例
 * @Description
 * @Author L
 * @Date Create by 2020/6/30
 */
@Configuration
@EnableSwagger2 //启用swagger2
public class Swagger2Config {

    //是否开启 swagger-ui 功能，默认为false
    @Value("${swagger.enable:false}")
    private Boolean enable;

    private static final Logger log = LoggerFactory.getLogger(Swagger2Config.class);

    @Bean
    public Docket createRestApi() {
        log.info("Whether to open the Swagger service: {}", enable);
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                //需要Swagger描述的接口包路径，如果不想某接口暴露，可在接口上加@ApiIgnore注解
                .apis(RequestHandlerSelectors.basePackage("com.example.backend_template.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //配置在线文档的基本信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("BackendTemplate项目")
                .description("使基于SpringBoot的后端开发变得简单")
                .version("1.0")
                .build();
    }
}