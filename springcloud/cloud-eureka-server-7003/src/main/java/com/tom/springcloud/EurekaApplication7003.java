package com.tom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// 代表这是一个 Eureka的注册中心
@EnableEurekaServer
public class EurekaApplication7003 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication7003.class, args);
    }
}
