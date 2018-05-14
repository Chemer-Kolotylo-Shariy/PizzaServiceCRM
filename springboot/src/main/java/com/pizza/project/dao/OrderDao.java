package com.pizza.project.dao;

import com.pizza.project.model.Order;

import java.util.List;

public interface OrderDao extends CrudDao<Order> {
    Long removeByIdAndStatusClient(Long id);
    Long removeByIdAndStatusADMIN(Long id);
    Long changeStatus(Integer id, Integer status);
    List<Order> getByStatus(String status);
}
