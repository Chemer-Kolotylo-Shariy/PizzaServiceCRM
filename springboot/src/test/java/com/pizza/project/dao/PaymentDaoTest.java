package com.pizza.project.dao;

import com.pizza.project.model.Payment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentDaoTest {
    @Autowired
    PaymentDao paymentDao;

    @Test
    public void get(){
        Payment payment = paymentDao.get(1);
        Assert.assertNotNull("Payment method not found!", payment);
        System.out.println("\n!!!!!!\nPayment method: " + payment.getPayment() + "\n!!!!!!\n");
    }

    @Test
    public void create(){
        Integer id = paymentDao.create(new Payment("Przelew"));
        Assert.assertNotNull("Payment method not found!", id);
        System.out.println("\n!!!!!!\nPayment method: " + id + "\n!!!!!!\n");
    }

    @Test
    public void delete(){
        Integer id = paymentDao.remove(1);
        Assert.assertNotNull("Not found", id);
        System.out.println("Deleted successful: " + id);
    }

    @Test
    public void getAll(){
        List<Payment> payments = paymentDao.getAllPaymentMethods();
        Assert.assertNotNull("Payment methods not found", payments);
        System.out.println("\n!!!!!!!!!!\n");
        for (Payment p : payments) {
            System.out.println("Method: " + p.getPayment());
        }
        System.out.println("\n!!!!!!!!!!\n");
    }
}
