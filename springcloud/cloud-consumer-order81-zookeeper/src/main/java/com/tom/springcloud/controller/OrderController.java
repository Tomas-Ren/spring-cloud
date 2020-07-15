package com.tom.springcloud.controller;

import com.tom.springcloud.entites.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String INVOKE_URL = "http://cloud-payment-service";

    @GetMapping("/order/payment/zk")
    private String paymentzk(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
