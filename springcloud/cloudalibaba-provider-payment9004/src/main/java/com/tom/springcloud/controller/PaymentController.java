package com.tom.springcloud.controller;

import com.tom.springcloud.entites.CommonResult;
import com.tom.springcloud.entites.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap();

    static {
        hashMap.put(1L, new Payment(1L, "test1"));
        hashMap.put(2L, new Payment(2L, "test2"));
        hashMap.put(3L, new Payment(3L, "test3"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult paymentSQL (@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        if (payment == null) {
            return CommonResult.ok().data(null);
        }
        else {
            return CommonResult.ok().data("from sql, serverPort" + serverPort, payment);
        }
    }


}
