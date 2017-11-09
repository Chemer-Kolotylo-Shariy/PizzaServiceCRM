package com.pizza.project.service;

import com.pizza.project.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategoty();
    Long create(Category category);
    Long delete(Long id);
}
