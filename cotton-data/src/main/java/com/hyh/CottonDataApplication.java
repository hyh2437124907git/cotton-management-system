package com.hyh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hyh
 * @date 2022/10/3 16:28
 */
@SpringBootApplication
@MapperScan("com.hyh.model.mapper")
public class CottonDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(CottonDataApplication.class, args);
    }
}
