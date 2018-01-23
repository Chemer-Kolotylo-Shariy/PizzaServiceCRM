package com.pizza.project.dao;

import com.pizza.project.model.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDaoTest {
    @Autowired
    CategoryDao categoryDao;

    @Test
    public void create(){
        Integer id = categoryDao.createCategory(new Category("Deserty"));
        Assert.assertNotNull("Category haven`t been created! ", id);
        System.out.println("Category was created " + id);
    }

    @Test
    public void getCategory(){
        Category category = categoryDao.getCategory(2);
        Assert.assertNotNull("Categoru not found!", category);
        System.out.println("Category: " + category.getCategory());
    }

    @Test
    public void getAll(){
        List<Category> categoryList = categoryDao.getAllCategories();
        Assert.assertNotNull("Category not found!", categoryList);
        for (Category categ : categoryList) {
            System.out.println("" + categ.getId() + ". " + categ.getCategory());
        }
    }
}
