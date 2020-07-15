package com.tom.springcloud.service.impl;

import com.tom.springcloud.entites.Payment;
import com.tom.springcloud.mapper.PaymentMapper;
import com.tom.springcloud.service.PaymentServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentServcie {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
