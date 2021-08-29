package com.fzy;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 扫描mapper包
@MapperScan("com.fzy.xiaoshuo.dao")
@SpringBootApplication
public class XiaoshuoSpringbootApplication {

    public static void main(String[] args) {

        SpringApplication.run(XiaoshuoSpringbootApplication.class, args);
    }

}
