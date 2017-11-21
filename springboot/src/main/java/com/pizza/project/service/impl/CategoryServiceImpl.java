package com.pizza.project.service.impl;

import com.pizza.project.dao.CategoryDao;
import com.pizza.project.dao.ProductDao;
import com.pizza.project.model.Category;
import com.pizza.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Category> getAllCategoty() {
        List<Category> categories = categoryDao.getAllCategories();
        for (Category category : categories) {
            category.setProducts(productDao.getProductsByCategoryAndAmountNotNull(category.getCategory()));
        }
        return categoryDao.getAllCategories();
    }

    @Override
    public Long create(Category category) {
        return create(category);
    }

    @Override
    public Long delete(Long id) {
        return delete(id);
    }
}
