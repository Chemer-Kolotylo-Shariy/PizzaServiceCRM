package com.pizza.project.service;

import com.pizza.project.model.Product;

import java.util.List;

public interface ProductServise {
    Product getProductById(Long id);
    Long create(Product product);
    List<Product> getProductByCategory(String category);
    Long delete(Long id);
    Long update(Product product);
}
