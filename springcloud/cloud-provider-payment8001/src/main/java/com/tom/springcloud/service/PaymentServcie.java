package com.tom.springcloud.service;

import com.tom.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentServcie {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
