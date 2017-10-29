package com.pizza.project.dao;

import com.pizza.project.model.ClientAddress;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientAddressDaoTest {

    @Autowired
    private ClientAddressDao clientAddressDao;

    @Test
    public void getAll(){
        List<ClientAddress> clientAddresses = clientAddressDao.getAll();
        Assert.assertNotNull("List not found!", clientAddresses);
        for (ClientAddress c : clientAddresses) {
            System.out.println(c);
        }
    }
}
