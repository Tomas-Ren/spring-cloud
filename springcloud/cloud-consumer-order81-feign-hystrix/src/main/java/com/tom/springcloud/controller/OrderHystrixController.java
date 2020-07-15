package com.tom.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tom.springcloud.servcie.PaymentHystrixServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "Global_Fallback")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixServcie paymentHystrixServcie;


    @GetMapping("/consumer/payment/hustrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String s = paymentHystrixServcie.paymentInfo_OK(id);
        log.info(s);
        return s;
    }

    @GetMapping("/consumer/payment/hustrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        String s = paymentHystrixServcie.paymentInfo_TimeOut(id);
        log.info(s);
        return s;
    }

    @GetMapping("/consumer/payment/hustrix/GlobalTimeout")
    @HystrixCommand
    public String paymentInfo_Global_timeout() {
        int i = 10 / 0;
        return "成功";
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者81，对方支付系统繁忙请稍后重试，也可能是自己有错误";
    }

    public String Global_Fallback(){
        return "全局异常处理。。";
    }
}
