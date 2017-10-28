package com.pizza.project.dao;

import com.pizza.project.model.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientDaoTest {
    @Autowired
    private ClientDao clientDao;
    private Long id;

    @Test
    public void getById(){
        Client client = clientDao.get(1L);
        Assert.assertNotNull("User not finded", client);
        System.out.println("I got user " + client.getName());
    }
}
