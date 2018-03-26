package com.pizza.project.service;

import com.pizza.project.model.Order;
import com.pizza.project.model.json.OrderJson;

public interface OrderService {
    Long create(OrderJson order);
    Long changeStatus(Order order, String status);
}
