package com.pizza.project.service;

import com.pizza.project.model.OrderProduct;

import java.util.List;

public interface OrderProductService {
    OrderProduct getOrderProduct(Long idOrder, Long idProduct);
    List<OrderProduct> getOrdProd(Long idOrder);
    Long createOrdProd(OrderProduct orderProduct);
    Long updateOrdProd(OrderProduct orderProduct);
    Long deleteOrdProd(Long idOrder);

}
