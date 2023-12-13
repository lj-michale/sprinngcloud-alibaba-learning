package com.turing.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.turing.springboot.mapper")
public class TuringSpringbootServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuringSpringbootServiceApplication.class, args);
    }

}
