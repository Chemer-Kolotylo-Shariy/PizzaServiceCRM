package com.pizza.project.model;

import java.util.List;

public class Category {
    private int id;
    private String category;
    private List<Product>products;

    public Category() {
    }

    public Category(int id, String category, List<Product> products) {
        this.id = id;
        this.category = category;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
