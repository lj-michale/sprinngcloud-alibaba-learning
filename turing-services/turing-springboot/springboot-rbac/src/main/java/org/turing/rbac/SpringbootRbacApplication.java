package org.turing.rbac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2023/12/22 14:54
 */
@MapperScan("org.turing.rbac.dao")
@SpringBootApplication
public class SpringbootRbacApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRbacApplication.class, args);
    }

}
