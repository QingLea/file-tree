package com.liqing.treedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liqing.treedemo.mapper")
public class TreedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreedemoApplication.class, args);
    }
}
