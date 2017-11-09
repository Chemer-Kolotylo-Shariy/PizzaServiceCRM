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

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTest {

    @Autowired
    ProductDao productDao;
    @Autowired
    CategoryDao categoryDao;

    @Test
    public void create(){
        Long id = productDao.create(new Product("GYROS","sos, podwójny ser, gyros, cebula, kukurydza, pomidorki cherry, rukola", 100, "photo", 12.0, null, categoryDao.getCategory(1), Size.SIZE_L));
        Assert.assertNotNull("Product not created!", id);
        System.out.println("Product was created: " + id);
    }

    @Test
    public void get(){
        Product product = productDao.get(1L);
        Assert.assertNotNull("Product not found!", product);
        System.out.println("Product : " + product.getName() + " Price: " + product.getPriceWithPersent() );
    }

    @Test
    public void getListProductCountNotNull(){
        List<Product> products = productDao.getProductsByCategoryAndAmountNotNull("PIZZA");
        Assert.assertNotNull("Products not found!", products);
        System.out.println("List has: " + products.size() + " products");
    }
}
