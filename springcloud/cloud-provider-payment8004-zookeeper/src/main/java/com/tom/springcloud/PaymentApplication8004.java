package com.tom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient  // 该主借用于向使用 consul或者 zookeeper作为注册中心时注册服务
public class PaymentApplication8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8004.class, args);
    }
}
