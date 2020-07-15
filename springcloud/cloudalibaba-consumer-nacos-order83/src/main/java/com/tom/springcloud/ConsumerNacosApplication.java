package com.tom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacosApplication.class, args);
    }
}
