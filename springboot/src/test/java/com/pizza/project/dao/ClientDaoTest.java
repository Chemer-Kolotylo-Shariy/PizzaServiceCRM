package com.pizza.project.dao;

import com.pizza.project.model.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientDaoTest {
    @Autowired
    private ClientDao clientDao;
    private Long id;

    @Test
    public void getById(){
        Client client = clientDao.get(1L);
        Assert.assertNotNull("User not found", client);
        System.out.println("I got user " + client.getName());
    }

    @Test
    public void getByPhone(){
        Client client = clientDao.getByPhone(48537778445L);
        Assert.assertNotNull("User not found", client);
        System.out.println("I got user " + client.getName());
    }

    @Test
    public void getAll(){
        List<Client> clients = clientDao.getAllClients();
        Assert.assertNotNull("User not found", clients);
        for (Client c:clients) {
            System.out.println("I got user " + c.getName());
        }
    }
}
