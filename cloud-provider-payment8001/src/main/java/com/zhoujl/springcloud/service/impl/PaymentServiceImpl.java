package com.zhoujl.springcloud.service.impl;

import com.zhoujl.springcloud.dao.PaymentDao;
import com.zhoujl.springcloud.entities.Payment;
import com.zhoujl.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
