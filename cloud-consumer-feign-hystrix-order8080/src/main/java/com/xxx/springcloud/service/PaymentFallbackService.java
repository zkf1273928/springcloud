package com.xxx.springcloud.service;

import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--------------PaymentFallbackService-------------paymentInfo_TimeOut";
    }

    @Override
    public String paymentInfo_Ok(Integer id) {
        return "--------------PaymentFallbackService-------------paymentInfo_Ok";
    }
}
