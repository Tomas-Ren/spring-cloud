package com.tom.springcloud.service;

import com.tom.springcloud.entites.CommonResult;
import com.tom.springcloud.entites.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignServcie {

    @GetMapping("/payment/get/{id}")
    CommonResult get(@PathVariable("id") Long id);

    @PostMapping("/payment/create")
    CommonResult create(@RequestBody() Payment payment);

    @GetMapping(value = "payment/feign/timeout")
    String paymentFeignTimeout();
}
