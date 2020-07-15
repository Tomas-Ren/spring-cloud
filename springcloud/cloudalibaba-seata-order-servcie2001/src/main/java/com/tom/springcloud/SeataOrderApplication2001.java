package com.tom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 取消数据源自动配置
@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderApplication2001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderApplication2001.class, args);
    }
}
