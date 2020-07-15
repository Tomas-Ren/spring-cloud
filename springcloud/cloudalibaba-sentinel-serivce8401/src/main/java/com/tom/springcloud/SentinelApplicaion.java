package com.tom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SentinelApplicaion {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplicaion.class, args);
    }
}
