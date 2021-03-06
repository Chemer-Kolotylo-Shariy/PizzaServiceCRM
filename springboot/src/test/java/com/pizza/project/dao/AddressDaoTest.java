package com.pizza.project.dao;

import com.pizza.project.model.Address;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

    @Test
    public void getByParam(){
        Address address = addressDao.get("asd", "asd", 12);
        Assert.assertNotNull("Address not found", address);
        System.out.println("I got addres: " + address.getStreet() + " " +
            address.getHouse() + " " + address.getApartament());
    }

    @Test
    public void getAddressesByClientIdAndLableNotNull(){
        List<Address> addresses = addressDao.getAddressesByClientIdAndLableNotNull(1L);
        Assert.assertNotNull("List not found!", addresses);
        for (Address c : addresses) {
            System.out.println(c);
        }
    }

    @Test
    public void create(){
        Long id = addressDao.create(new Address("dobrzanskiego", "35", 320, null));
        Assert.assertNotNull("Address have not created!", id);
        System.out.println("Address with id: " + id + " was created!");
    }
}
