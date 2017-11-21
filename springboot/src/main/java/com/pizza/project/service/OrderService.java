package com.pizza.project.service;

import com.pizza.project.model.Order;

public interface OrderService {
    Long create(Order order);
    Long changeStatus(Order order, String status);
}
