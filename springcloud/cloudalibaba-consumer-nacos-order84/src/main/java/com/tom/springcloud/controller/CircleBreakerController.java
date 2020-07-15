package com.tom.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.tom.springcloud.entites.CommonResult;
import com.tom.springcloud.entites.Payment;
import com.tom.springcloud.service.PaymentServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URI = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")   // 没有配置
//    @SentinelResource(value = "fallback", fallback = "handlerFallback") // fallback只负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")  // blockHandler只负责 sentinel控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")
    public CommonResult fallback(@PathVariable Long id) {
        CommonResult result = restTemplate.getForObject(SERVICE_URI + "/paymentSQL/" + id, CommonResult.class);

        if (id == 4) {
            throw new IllegalArgumentException("非法传参");
        }
        else if (result.getData() == null) {
            throw new NullPointerException("空指针，无对应记录");
        }

        return result;
    }
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return CommonResult.error().message("兜底异常，内容：" + e.getMessage()).data("payment", payment);
    }
    public CommonResult blockHandler(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return CommonResult.error().message("blockHandler-sentinel限流，内容：" + e.getMessage()).data("payment", payment);
    }


    //===================OpenFeign
    @Autowired
    private PaymentServcie paymentServcie;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    CommonResult paymentSQL (@PathVariable("id") Long id){
        return paymentServcie.paymentSQL(id);
    }

}
