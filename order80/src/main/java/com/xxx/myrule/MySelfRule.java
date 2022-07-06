package com.xxx.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.xxx.springcloud.entities.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//改变Ribbon负载均衡的方法
//Ribbon是内部的负载均衡（医院找科室） nigx是服务器的负载均衡（相当于找医院）
@Configuration
public class MySelfRule {


    /**
     * 轮询算法调用负载均衡（服务器地址存放在List中）
     * 实现方法：rest接口第几次请求数%服务器集群总数量 = 实际调用的服务器位置的下标，每次服务重启后rest接口计数从1开始
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();//定义为随机
    }

/*    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        ArrayList<Payment> payments = new ArrayList<>();
        Payment payment1 = new Payment(10L, "15");
        Payment payment2 = new Payment(11L, "15");
        Payment payment3 = new Payment(12L, "15");
        Payment payment4 = new Payment(13L, "15");
        Payment payment5 = new Payment(14L, "15");
        payments.add(payment1);
        payments.add(payment2);
        payments.add(payment3);
        payments.add(payment4);
        payments.add(payment5);
        objects.add(10L);
        objects.add(13L);
        ArrayList<Object> values = new ArrayList<>();
        payments.stream().forEach(payment -> {
            List<Object> collect = objects.stream().filter(item -> item.equals(payment.getId())).collect(Collectors.toList());
            values.add(collect.size() > 0 ? collect.get(0) : 0);
        });
    }*/
}
