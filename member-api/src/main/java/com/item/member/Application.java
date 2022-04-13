package com.item.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: yr
 * @desc: 启动类
 * @date: 2022/4/13 12:06
 */
@SpringBootApplication
@MapperScan(basePackages = "com.item.member")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class , args);
    }
}
