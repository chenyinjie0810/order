package com.wechat.product8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Product8001Application {

    public static void main(String[] args) {
        SpringApplication.run(Product8001Application.class, args);
    }

}
