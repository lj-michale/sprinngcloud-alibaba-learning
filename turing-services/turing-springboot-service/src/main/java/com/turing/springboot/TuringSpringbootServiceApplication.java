package com.turing.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.turing.springboot.mapper"})
public class TuringSpringbootServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuringSpringbootServiceApplication.class, args);
    }

}
