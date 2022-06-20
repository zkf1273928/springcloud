package com.xxx.springcloud.controller;

import com.xxx.springcloud.entities.CommonResult;
import com.xxx.springcloud.entities.Payment;
import com.xxx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/add")
    public CommonResult add(@RequestBody Payment payment) {
        Integer add = paymentService.add(payment);
        Long id = payment.getId();
        log.info(add.toString());
        if (add > 0) {
            return new CommonResult(200, "success,serverport,id"+serverPort+","+add,id);
        }else {
            return new CommonResult(444,"失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById.getSerial()!=null){
            return new CommonResult(200,"成功,serverPort"+serverPort,paymentById);
        }else {
            return new CommonResult(444,"失败");
        }
    }

    //返回当前端口
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
