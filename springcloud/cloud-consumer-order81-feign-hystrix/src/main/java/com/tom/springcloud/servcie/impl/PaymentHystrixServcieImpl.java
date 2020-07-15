package com.tom.springcloud.servcie.impl;

import com.tom.springcloud.servcie.PaymentHystrixServcie;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServcieImpl implements PaymentHystrixServcie {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "--- PaymentHystrixServcieImpl fall back";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--- PaymentHystrixServcieImpl fall back";
    }
}
