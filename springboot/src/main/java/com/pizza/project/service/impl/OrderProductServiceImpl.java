package com.pizza.project.service.impl;

import com.pizza.project.dao.ClientDao;
import com.pizza.project.dao.OrderDao;
import com.pizza.project.dao.OrderProductDao;
import com.pizza.project.model.OrderProduct;
import com.pizza.project.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    private OrderProductDao orderProductDao;
    private OrderDao orderDao;
    private ClientDao clientDao;

    @Autowired
    public OrderProductServiceImpl(OrderProductDao orderProductDao, OrderDao orderDao, ClientDao clientDao) {
        this.orderProductDao = orderProductDao;
        this.orderDao = orderDao;
        this.clientDao = clientDao;
    }

    @Override
    public OrderProduct getOrderProduct(Long idOrder, Long idProduct) {
        return null;
    }

    @Override
    public List<OrderProduct> getOrdProd(Long idOrder) {
        return orderProductDao.getAllByOrderId(idOrder);
    }

    @Override
    public Long createOrdProd(OrderProduct orderProduct) {
        return null;
    }

    @Override
    public Long updateOrdProd(OrderProduct orderProduct) {
        return null;
    }

    @Override
    public Long deleteOrdProd(Long idOrder) {
        return null;
    }

    @Override
    public List<OrderProduct> getAllByOrderStatus(String status) {
        return orderProductDao.getAllByOrderStatus(status);
    }
}
