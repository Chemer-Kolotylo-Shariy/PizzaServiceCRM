package com.pizza.project.dao;

import com.pizza.project.model.Address;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressDaoTest {
    @Autowired
    AddressDao addressDao;

    @Test
    public void getById(){
        Address address = addressDao.get(1L);
        Assert.assertNotNull("Address not found", address);
        System.out.println("I got addres: " + address.getStreet() + " " +
            address.getHouse() + " " + address.getApartament());
    }
}
