package com.xxx.springcloud.service.impl;

import com.xxx.springcloud.dao.PaymentDao;
import com.xxx.springcloud.entities.Payment;
import com.xxx.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Parameter;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Integer add(Payment payment) {
        Integer add = paymentDao.add(payment);
        return add;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
