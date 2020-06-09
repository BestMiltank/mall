package com.miltank.fileclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.miltank.fileclient.mapper")
@SpringBootApplication
@EnableEurekaClient
public class FileClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileClientApplication.class, args);
    }

}
