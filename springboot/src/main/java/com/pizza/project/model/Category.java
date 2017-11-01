package com.pizza.project.model;

import java.util.List;

public class Category {
    private Integer id;
    private String category;
    private List<Product>products;

    public Category() {
    }

    public Category(Integer id, String category, List<Product> products) {
        this.id = id;
        this.category = category;
        this.products = products;
    }

    public Category(Integer id, String category) {
        this.id = id;
        this.category = category;
    }

    public Category(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
