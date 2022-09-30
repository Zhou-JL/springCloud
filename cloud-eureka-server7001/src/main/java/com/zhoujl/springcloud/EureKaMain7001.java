package com.zhoujl.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer    //代表这是Eureka的注册中心
public class EureKaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EureKaMain7001.class, args);
    }
}
