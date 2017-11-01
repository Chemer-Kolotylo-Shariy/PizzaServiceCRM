package com.pizza.project.dao;

import com.pizza.project.model.Category;

import java.util.List;

public interface CategoryDao extends CrudDao<Category> {
    List<Category> getAllCategories();
    Integer createCategory(Category object);
    Category getCategory(Integer id);
}
