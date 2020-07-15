package com.tom.springcloud.service.impl;

import com.tom.springcloud.entites.CommonResult;
import com.tom.springcloud.service.PaymentServcie;
import org.springframework.stereotype.Component;

@Component
public class PaymentServcieImpl implements PaymentServcie {
    @Override
    public CommonResult paymentSQL(Long id) {
        return CommonResult.error().message("服务降级返回");
    }
}
