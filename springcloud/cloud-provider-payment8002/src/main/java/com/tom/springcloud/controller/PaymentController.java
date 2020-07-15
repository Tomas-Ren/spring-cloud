package com.tom.springcloud.controller;

import com.tom.springcloud.entites.CommonResult;
import com.tom.springcloud.entites.Payment;
import com.tom.springcloud.service.PaymentServcie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@Slf4j
@Api(tags = "支付管理")
public class PaymentController {

    @Autowired
    private PaymentServcie paymentServcie;

    @Value(("${server.port}"))
    private String paymentPort;

    @ApiOperation("插入数据")
    @PostMapping("/payment/create")
    public CommonResult create(@ApiParam(value = "插入对象", required = true, name = "payment") @RequestBody() Payment payment) {
        int i = paymentServcie.create(payment);
        log.info("***插入结果：" + i);

        if (i > 0) {
            return CommonResult.ok().data("result", i).message(paymentPort);
        }
        else {
            return CommonResult.error();
        }

    }


    @ApiOperation("根据id查询")
    @GetMapping("/payment/get/{id}")
    public CommonResult get(@ApiParam(value = "查询id", required = true, name = "id") @PathVariable("id") Long id) {
        Payment payment = paymentServcie.getPaymentById(id);
        log.info("***查询结果：" + payment);

        if (payment != null) {
            return CommonResult.ok().data("payment", payment).message(paymentPort);
        }
        else {
            return CommonResult.error();
        }
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return paymentPort;
    }
}
