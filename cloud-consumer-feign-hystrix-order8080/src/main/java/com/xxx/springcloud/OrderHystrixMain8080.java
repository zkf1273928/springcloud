package com.xxx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix//服务调用方开启hystrix
public class OrderHystrixMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain8080.class,args);
    }
}

