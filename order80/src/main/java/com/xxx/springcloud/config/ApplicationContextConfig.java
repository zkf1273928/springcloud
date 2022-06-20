package com.xxx.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced   使用自己的负载算法需要竹雕   原来是ribbon+resttemplate来实现   现在需要自己方法+resttemplate来实现
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
