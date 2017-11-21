package com.pizza.project.service.impl;

import com.pizza.project.dao.OrderDao;
import com.pizza.project.model.Order;
import com.pizza.project.model.enums.OrderStatus;
import com.pizza.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderDao orderDao;

    private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private DateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private Calendar date;

//    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    Calendar cal = Calendar.getInstance();
//System.out.println(dateFormat.format(cal)); //2016/11/16 12:08:43

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Long create(Order order) {
        date = Calendar.getInstance();
        order.setDate(dateFormat.format(date));
        order.setTime(timeFormat.format(date));
        order.setOrderStatus(OrderStatus.CLIENT_CONFIR);
        return orderDao.create(order);
    }

    @Override
    public Long changeStatus(Order order, String status) {
        return orderDao.changeStatus(order, status);
    }
}
