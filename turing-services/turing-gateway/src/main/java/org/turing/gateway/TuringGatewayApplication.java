package org.turing.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2023/12/22 10:02
 */
@EnableDiscoveryClient
@SpringBootApplication
public class TuringGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuringGatewayApplication.class, args);
    }

}
