package com.pizza.project.dao;

import com.pizza.project.model.OrderProduct;

import java.util.List;

public interface OrderProductDao extends CrudDao<OrderProduct> {
    List<OrderProduct> getAllByOrderId(Long idOrder);
    OrderProduct getOrderProduct(Long idOrder, Long idProduct);

}
