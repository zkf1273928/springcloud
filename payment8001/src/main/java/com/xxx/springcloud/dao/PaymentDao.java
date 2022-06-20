package com.xxx.springcloud.dao;

import com.xxx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Parameter;

@Mapper
public interface PaymentDao {

    public Integer add(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
