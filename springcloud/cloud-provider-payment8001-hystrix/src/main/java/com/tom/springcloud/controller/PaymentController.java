package com.tom.springcloud.controller;

import com.tom.springcloud.service.PaymentServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentServcie paymentServcie;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentServcie.paymentInfo_OK(id);
        log.info(result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentServcie.paymentInfo_TimeOut(id);
        log.info(result);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreader(@PathVariable("id") Integer id) {
        String s = paymentServcie.paymentCircuitBreader(id);
        log.info("****result:" + s);
        return s;
    }
}
