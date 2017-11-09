package com.pizza.project.service;

import com.pizza.project.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment get(Integer id);
    Integer create(Payment payment);
    List<Payment> getAllPayments();
}
