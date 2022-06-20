package com.xxx.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//改变Ribbon负载均衡的方法
//Ribbon是内部的负载均衡（医院找科室） nigx是服务器的负载均衡（相当于找医院）
@Configuration
public class MySelfRule {


    /**
     * 轮询算法调用负载均衡（服务器地址存放在List中）
     * 实现方法：rest接口第几次请求数%服务器集群总数量 = 实际调用的服务器位置的下标，每次服务重启后rest接口计数从1开始
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}
