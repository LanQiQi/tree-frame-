package com.lq.ztreedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lq.ztreedemo.mapper")
public class ZtreeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZtreeDemoApplication.class, args);
    }

}
