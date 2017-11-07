package com.pizza.project.dao;

import com.pizza.project.model.Payment;

import java.util.List;

/**
 * Create by Andrii Chemer
 * */
public interface PaymentDao<T> {
    List<T> getAllPaymentMethods();
    Payment get(Integer id);
    Integer create(Payment payment);
    Integer remove(Integer id);
}
