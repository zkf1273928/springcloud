package com.xxx.springcloud.config;

import feign.Logger;
import org.apache.commons.logging.LogFactoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * openFeign详细日志设置
 */
@Component
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
