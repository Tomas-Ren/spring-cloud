package com.tom.springcloud.mapper;

import com.tom.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
