package com.pizza.project.dao;

import com.pizza.project.model.Product;

import java.util.List;

public interface ProductDao extends CrudDao<Product> {
    List<Product> getProductsByCategory(String category);

}
