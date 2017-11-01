package com.pizza.project.dao;

import com.pizza.project.model.Category;
import com.pizza.project.model.Product;
import com.pizza.project.model.enums.Size;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTest {

    @Autowired
    ProductDao productDao;
    @Autowired
    CategoryDao categoryDao;

    @Test
    public void create(){
        Long id = productDao.create(new Product("coca-cola","napoj gazowany bez cukru", 10, "F://foto", 4.50, null, categoryDao.getCategory(1), Size.SIZE_1_L));
        Assert.assertNotNull("Product not created!", id);
        System.out.println("Product was created: " + id);
    }

    @Test
    public void get(){
        Product product = productDao.get(1L);
        Assert.assertNotNull("Product not found!", product);
        System.out.println("Product : " + product.getName() + " Price: " + product.getPriceWithPersent() );
    }
}
