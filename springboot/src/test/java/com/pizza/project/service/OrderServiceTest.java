package com.pizza.project.service;

import com.pizza.project.dao.PaymentDao;
import com.pizza.project.model.Address;
import com.pizza.project.model.Client;
import com.pizza.project.model.Order;
import com.pizza.project.model.enums.Delivery;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    OrderService orderService;
    @Autowired
    PaymentDao paymentDao;
    @Test
    public void createOrder(){
//        Long id = orderService.create(new Order(null, null, null, 34.00, null, paymentDao.get(1), Delivery.DELIVERY_MYSELF, new Client("Andrii", null, null, Long.parseLong("537778445"), null, null), new Address("dob", "213", 23, null)));
//        Assert.assertNotNull("Can not create order! ERROR", id);
//        System.out.println("ORDER_ORDER_ORDER_ORDER_ORDER_ORDER_ORDER________" + id);
    }

}
