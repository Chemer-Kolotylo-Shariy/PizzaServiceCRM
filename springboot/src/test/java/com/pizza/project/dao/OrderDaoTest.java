package com.pizza.project.dao;

import com.pizza.project.model.Order;
import com.pizza.project.model.Payment;
import com.pizza.project.model.enums.Delivery;
import com.pizza.project.model.enums.OrderStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {
    @Autowired
    OrderDao orderDao;
    @Autowired
    ClientDao clientDao;
    @Autowired
    AddressDao addressDao;
    @Autowired
    PaymentDao<Payment> paymentDao;
    @Autowired
    CategoryDao categoryDao;

    @Test
    public void get(){
        Order order = orderDao.get(6L);
        Assert.assertNotNull("Order not found!", order);
        System.out.println("=====\nOrder id: " + order.getId() + "\n=====");
    }

    @Test
    public void create(){
        Long id = orderDao.create(new Order("06.11.2017", "21:13:25", 11.5, OrderStatus.CLIENT_CONFIR, paymentDao.get(1), Delivery.DELIVERY_MYSELF, clientDao.get(3L), addressDao.get(3L)));
        Assert.assertNotNull("Order don`t find!", id);
        System.out.println("=====\nOrder id: " + id +"\n=====");
    }

    @Test
    public void removeByIdAndStatusClient(){}
}
