package com.pizza.project.dao;

import com.pizza.project.model.Client;
import com.pizza.project.model.enums.Role;
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
        Client client = clientDao.get(3L);
        Assert.assertNotNull("User not found", client);
        System.out.println("I got user " + client.getName());
    }

    @Test
    public void getByPhone(){
        Long number = 537778445L;
        Client client = clientDao.getByPhone(22222222L);
        Assert.assertNotNull("User not found", client);
        System.out.println("I got user " + client.getName());
    }

    @Test
    public void deleteById(){
        Long id = clientDao.remove(2L);
        Assert.assertNotNull("Client not found", id);
        System.out.println("I deleted Client with id " + id);
    }

    @Test
    public void createClient() {
//        id = clientDao.create(new Client( "Andrii", "Chemer", "ichemer@icloud.com", (long)570637376, "111111",   Role.ROLE_ADMIN));
        id = clientDao.create(new Client( "Andrii", "Chemer", "test@test.com", (long)22222222, "22222222",   Role.ROLE_CHEF));
        Assert.assertNotNull("Client not created", id);
        System.out.println("Client with id " + id + " created");
    }

    @Test
    public void createClientWithoutPassword() {
        id = clientDao.create(new Client( "Vika", null, null, (long)570637376, null,   Role.ROLE_KLIENT));
        Assert.assertNotNull("Client not created", id);
        System.out.println("Client with id " + id + " created");
    }

    @Test
    public void getAll(){
        List<Client> clients = clientDao.getAllClients();
        Assert.assertNotNull("User not found", clients);
        for (Client c:clients) {
            System.out.println("I got user " + c.getName());
        }
    }

    @Test
    public void update(){

    }
}
