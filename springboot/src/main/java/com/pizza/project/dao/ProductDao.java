package com.pizza.project.dao;

import com.pizza.project.model.Product;

import java.util.List;
/**
 * Create by Andrii Chemer
 * */
public interface ProductDao extends CrudDao<Product> {
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByCategoryAndAmountNotNull(String category);


}
