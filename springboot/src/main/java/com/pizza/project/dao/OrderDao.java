package com.pizza.project.dao;

import com.pizza.project.model.Order;

public interface OrderDao extends CrudDao<Order> {
    Long removeByIdAndStatusClient(Long id);
    Long removeByIdAndStatusADMIN(Long id);
    Long changeStatus(Order order, String status);

}
