package com.xxx.springcloud.controller;

import com.xxx.springcloud.entities.CommonResult;
import com.xxx.springcloud.entities.Payment;
import com.xxx.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/order/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentTimeOut(){
        //openFeign底层也是ribbon 客户端一般默认等一分钟
        return paymentFeignService.paymentTimeOut();
    }
}
