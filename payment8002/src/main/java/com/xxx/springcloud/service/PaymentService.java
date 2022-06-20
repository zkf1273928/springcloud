package com.xxx.springcloud.service;

import com.xxx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public Integer add(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
