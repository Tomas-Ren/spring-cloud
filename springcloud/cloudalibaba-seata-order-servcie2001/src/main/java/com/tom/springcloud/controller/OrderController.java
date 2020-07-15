package com.tom.springcloud.controller;

import com.tom.springcloud.domain.CommonResult;
import com.tom.springcloud.domain.Order;
import com.tom.springcloud.servcie.OrderServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderServcie orderServcie;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderServcie.create(order);
        return CommonResult.ok();
    }
}
