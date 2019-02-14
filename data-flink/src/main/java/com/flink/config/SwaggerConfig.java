package com.flink.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.or;

/**
 * @author : shengbin
 * @since : 2018/04/03
 */
@Configuration
public class SwaggerConfig {

    // 环境
    @Value("${spring.profiles.active}")
    private String ENV;

    private ApiInfo initApiInfo() {
        // 标题
        // 简单的描述
        // 版本
        // 作者
        // 网站链接
        return new ApiInfo("Flink Inferface Platform API",
                initContextInfo(),
                "2.6.0",
                "service for rest api", "shengbin",
                "The Apache License, Version 2.0", // 链接显示文字
                "http://www.baidu.com"
        );
    }

    private String initContextInfo() {
        return "REST API 设计说明平台。" + "<br/>" +
                "以下是本项目的API文档";
    }

    @Bean
    public Docket restfulApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName("RestfulApi")
                .genericModelSubstitutes(ResponseEntity.class).useDefaultResponseMessages(true).forCodeGeneration(false)
                .pathMapping("");
        if (ENV.equals("production")) {
            return docket.select().paths(PathSelectors.none()).build().apiInfo(initApiInfo());
        } else {
            return docket.select()
                    .paths(or(PathSelectors.regex("/.*")))//过滤的接口
                    .paths(PathSelectors.any()).build().apiInfo(initApiInfo());
        }
    }

}