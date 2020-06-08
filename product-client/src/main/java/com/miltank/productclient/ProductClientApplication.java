package com.miltank.productclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.miltank.productclient.mapper")
public class ProductClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductClientApplication.class, args);
    }

}
