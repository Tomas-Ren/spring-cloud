package com.tom.springcloud;

import com.tom.myrule.RuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = RuleConfig.class)
public class OrderApplication81 {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication81.class, args);
    }
}
