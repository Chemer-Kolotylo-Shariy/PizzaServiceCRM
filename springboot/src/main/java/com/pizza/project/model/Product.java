package com.pizza.project.model;

import com.pizza.project.model.enums.Size;

public class Product {
    private Long id;
    private String name;
    private String specification;
    private int amount;
    private String foto;
    private double price;
    private int persent;
    private Category category;
    private Size size;

    public Product(Long id, String name, String specification,
                   int amount, String foto, double price, int persent,
                   Category category, Size size) {
        this.id = id;
        this.name = name;
        this.specification = specification;
        this.amount = amount;
        this.foto = foto;
        this.price = price;
        this.persent = persent;
        this.category = category;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPersent() {
        return persent;
    }

    public void setPersent(int persent) {
        this.persent = persent;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
