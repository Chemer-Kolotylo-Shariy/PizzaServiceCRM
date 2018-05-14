package com.pizza.project.dao;

import com.pizza.project.model.Order;
import com.pizza.project.model.OrderProduct;
import com.pizza.project.model.Product;
import com.pizza.project.model.enums.Delivery;
import com.pizza.project.model.enums.OrderStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderProductDaoTest {
    @Autowired
    OrderProductDao orderProductDao;

    @Test
    public void create(){
        Long id = orderProductDao.create(new OrderProduct(new Order(3L), new Product(6), 3));
        Assert.assertNotNull("Order don`t find!", id);
        System.out.println("=====\nOrder id: " + id +"\n=====");
    }

    @Test
    public void getById(){
        List<OrderProduct> order = orderProductDao.getAllByOrderId(18L);
        Assert.assertNotNull("Order not found!", order);
        for (OrderProduct o:order) {
            System.out.println("=====\nOrder id: " + o.getOrder().getId() + "  |  " + o.getProduct().getName() + "=====" + o.getCountProduct() + "\n=====");
        }
    }

    @Test
    public void getByStatus(){
        List<OrderProduct> order = orderProductDao.getAllByOrderStatus("MANAGER_CONFIR"); //CLIENT_CONFIR  //MANAGER_CONFIR
        Assert.assertNotNull("Order not found!", order);
        for (OrderProduct o:order) {
            System.out.println("=====\nOrder id: " + o.getOrder().getId() + "  |  " + o.getProduct().getName() + "=====" + o.getCountProduct() + "\n=====");
        }
    }
}
