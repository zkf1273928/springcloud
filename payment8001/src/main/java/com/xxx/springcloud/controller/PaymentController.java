package com.xxx.springcloud.controller;


import com.xxx.springcloud.entities.CommonResult;
import com.xxx.springcloud.entities.Payment;
import com.xxx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

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
    public CommonResult<Payment> getById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById.getSerial()!=null){
            return new CommonResult(200,"成功,serverPort"+serverPort,paymentById);
        }else {
            return new CommonResult(444,"失败");
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services){
            log.info("***********element"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    //返回当前端口
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    //Feign超时测试接口
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentTimeOut(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.fillInStackTrace();
        }
        return serverPort;
    }
}
