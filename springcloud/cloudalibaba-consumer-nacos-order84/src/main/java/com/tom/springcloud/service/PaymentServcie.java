package com.tom.springcloud.service;

import com.tom.springcloud.entites.CommonResult;
import com.tom.springcloud.service.impl.PaymentServcieImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentServcieImpl.class)
public interface PaymentServcie {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult paymentSQL (@PathVariable("id") Long id);
}
