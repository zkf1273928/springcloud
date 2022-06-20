package com.xxx.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import io.micrometer.core.instrument.binder.hystrix.HystrixMetricsBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//服务被调方开启hystrix
public class PaymentHytrsixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHytrsixMain8001.class,args);
    }

    /**
     *此配置是问了服务监控而配置，与服务容错本身无关，是springCloud升级后的坑
     *ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"
     * 只要在自己的项目里配置上下面的servlet就好了
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
