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

import java.util.ArrayList;
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
//        Long idL = productDao.create(new Product("Margarita","sos, ser, cebula, kiełbasa wiejska, boczek, ogórek konserwowy, ser wędzony", 100, "pizzamargarita", 10.00, 0, categoryDao.getCategory(2), Size.SIZE_L));
//        Long idM = productDao.create(new Product("Margarita","sos, ser, cebula, kiełbasa wiejska, boczek, ogórek konserwowy, ser wędzony", 100, "pizzamargarita", 15.00, 0, categoryDao.getCategory(2), Size.SIZE_M));
//        Long idS = productDao.create(new Product("Margarita","sos, ser, cebula, kiełbasa wiejska, boczek, ogórek konserwowy, ser wędzony", 100, "pizzamargarita", 20.00, 0, categoryDao.getCategory(2), Size.SIZE_S));
//        Long idL = productDao.create(new Product("Pizzameet","sos, ser, cebula, kiełbasa wiejska, boczek, ogórek konserwowy, ser wędzony", 100, "pizzameet", 10.00, 0, categoryDao.getCategory(2), Size.SIZE_L));
//        Long idM = productDao.create(new Product("Pizzameet","sos, ser, cebula, kiełbasa wiejska, boczek, ogórek konserwowy, ser wędzony", 100, "pizzameet", 15.00, 0, categoryDao.getCategory(2), Size.SIZE_M));
//        Long idS = productDao.create(new Product("Pizzameet","sos, ser, cebula, kiełbasa wiejska, boczek, ogórek konserwowy, ser wędzony", 100, "pizzameet", 20.00, 0, categoryDao.getCategory(2), Size.SIZE_S));
//        Long idL = productDao.create(new Product("Filadelfia","ryż, losoś, ser, ogórek, awokado, nori", 100, "sushija", 15.00, 0, categoryDao.getCategory(3), Size.SIZE_UNIVERSAL));
//        Long idM = productDao.create(new Product("Czerwony drakon","ryż, losoś, ser, ogórek, awokado, nori", 100, "sushiki", 17.00, 0, categoryDao.getCategory(3), Size.SIZE_UNIVERSAL));
//        Long idS = productDao.create(new Product("Jakiś sushi","ryż, losoś, ser, ogórek, awokado, nori", 100, "sushili", 25.50, 0, categoryDao.getCategory(3), Size.SIZE_UNIVERSAL));
//        Long idL = productDao.create(new Product("Chiscake","---", 100, "chiskake", 5.00, 0, categoryDao.getCategory(4), Size.SIZE_UNIVERSAL));
//        Long idM = productDao.create(new Product("Krem mleko","---", 100, "formleko", 7.00, 0, categoryDao.getCategory(4), Size.SIZE_UNIVERSAL));
//        Long idS = productDao.create(new Product("Żele banan","---", 100, "zele", 6.50, 0, categoryDao.getCategory(4), Size.SIZE_UNIVERSAL));
        Long idL = productDao.create(new Product("Lipton","", 100, "lipton", 5.00, 0, categoryDao.getCategory(1), Size.SIZE_05_L));
        Long idM = productDao.create(new Product("Merinda","", 100, "merinda", 5.00, 0, categoryDao.getCategory(1), Size.SIZE_05_L));
        Long idS = productDao.create(new Product("Pepsi","", 100, "pepsi", 5.00, 0, categoryDao.getCategory(1), Size.SIZE_05_L));
        Assert.assertNotNull("Product not created!", idL);
        System.out.println("Product was created: " + idL + " " + idM + " "+ idS + " ");
    }
    // 1 - napoj
    // 2 - pizza
    // 3 - sushi
    // 4 - deserty

    @Test
    public void update(){
        Long id = productDao.create(new Product("Hawajska","sos, ser, szynka, salami, boczek, kukurydza, oliwki, czosnek", 100, "pizzahawajska", 15.0, 0, categoryDao.getCategory(1), Size.SIZE_M));
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

    @Test
    public void g(){
        List<ArrayList<String>> lists = new ArrayList<>();
        ArrayList<String> newList;

        for (int i = 0; i < 10; i++) {
            newList = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                newList.add(i + "a");
            }
            lists.add(newList);
        }


        int i = 0;
        for (ArrayList<String> a: lists) {
            System.out.println(a.get(9));

        }
    }
}
