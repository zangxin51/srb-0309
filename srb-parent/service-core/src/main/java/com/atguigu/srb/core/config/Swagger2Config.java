package com.atguigu.srb.core.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName Swagger2Config.java
 * @Description TODO
 * @createTime 2022年07月15日 09:21:00
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket adminConfig() {

        Docket coreAdmin = new Docket(DocumentationType.SWAGGER_2)
                .groupName("coreAdmin")
                .apiInfo(getApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();

        return coreAdmin;
    }

    private ApiInfo getApiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("尚融宝后台管理系统-API文档")
                .description("本文档描述了尚融宝后台管理系统接口")
                .version("1.0")
                .contact(new Contact("cqs", "http://www.atguigu.com", "cqs@gmail.com"))
                .build();
        return apiInfo;
    }
}
