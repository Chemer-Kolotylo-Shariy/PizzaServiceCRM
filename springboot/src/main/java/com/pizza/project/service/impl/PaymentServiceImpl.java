package com.pizza.project.service.impl;

import com.pizza.project.dao.PaymentDao;
import com.pizza.project.model.Payment;
import com.pizza.project.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    @Transactional
    public Payment get(Integer id) {
        return paymentDao.get(id);
    }

    @Override
    @Transactional
    public Integer create(Payment payment) {
        return create(payment);
    }

    @Override
    @Transactional
    public List<Payment> getAllPayments() {
        return paymentDao.getAllPaymentMethods();
    }
}
