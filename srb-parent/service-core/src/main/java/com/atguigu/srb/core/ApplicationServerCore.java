package com.atguigu.srb.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName ApplicationServerCore.java
 * @Description TODO
 * @createTime 2022年07月13日 16:57:00
 */
@SpringBootApplication
@MapperScan("com.atguigu.srb.core.mapper")
public class ApplicationServerCore {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationServerCore.class, args);
    }
}
