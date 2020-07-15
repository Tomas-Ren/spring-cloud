package com.tom.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.tom.springcloud.entites.CommonResult;
import com.tom.springcloud.entites.Payment;
import com.tom.springcloud.service.PaymentFeignServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignServcie paymentFeignServcie;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        CommonResult commonResult = paymentFeignServcie.get(id);
        return commonResult;
    }

    @GetMapping("/comsumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        // openfeign-ribbon 客户端一般等待一秒钟
        return paymentFeignServcie.paymentFeignTimeout();
    }
}
