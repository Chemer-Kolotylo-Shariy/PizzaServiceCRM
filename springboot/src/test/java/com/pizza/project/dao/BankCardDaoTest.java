package com.pizza.project.dao;

import com.pizza.project.model.BankCard;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankCardDaoTest {

    @Autowired
    BankCardDao bankCardDao;
    @Autowired
    ClientDao clientDao;

    @Test
    public void create(){
        Long id = bankCardDao.create(new BankCard(111111111111114L,1114,114));
        Assert.assertNotNull("Bank card haven`t been created", id);
        System.out.println("Bank card was create: " + id);
    }

    @Test
    public void createWithClientId(){
        Long id = bankCardDao.createWithClientId(new BankCard(1111111111111112L,1112,112,clientDao.get(3L)));
        Assert.assertNotNull("Bank card haven`t been created", id);
        System.out.println("Bank card was create: " + id);
    }

    @Test
    public void getByIdClient(){
        List<BankCard> bankCards = bankCardDao.getByClientId(3L);
        Assert.assertNotNull("Bank card not found!", bankCards);
        for (BankCard b : bankCards) {
            System.out.println("Number of bank card: " + b.getNumber());
        }

    }
}
