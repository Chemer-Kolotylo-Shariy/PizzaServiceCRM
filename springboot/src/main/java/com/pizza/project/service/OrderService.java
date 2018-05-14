package com.pizza.project.service;

import com.pizza.project.model.Order;
import com.pizza.project.model.json.OrderJson;

import java.util.List;

public interface OrderService {
    Long create(OrderJson order);
    Long changeStatus(Integer id, Integer status);
    List<Order> getOrdersByStatus(String status);
}
