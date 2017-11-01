package com.pizza.project.model;

import com.pizza.project.model.enums.Size;

public class Product {
    private Long id;
    private String name;
    private String specification;
    private Integer amount;
    private String photo;
    private Double price;
    private Integer persent;
    private Category category;
    private Size size;
    private Double priceWithPersent;

    public Product() {
    }

    public Product(Long id, String name, String specification,
                   Integer amount, String photo, Double price, Integer persent,
                   Category category, Size size) {
        this.id = id;
        this.name = name;
        this.specification = specification;
        this.amount = amount;
        this.photo = photo;
        this.price = price;
        this.persent = persent;
        this.category = category;
        this.size = size;
    }

    public Product(String name, String specification, Integer amount, String photo, Double price, Integer persent, Category category, Size size) {
        this.name = name;
        this.specification = specification;
        this.amount = amount;
        this.photo = photo;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String foto) {
        this.photo = foto;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public Double getPriceWithPersent() {
        if (persent != 0){
            return (((double)persent) / 100) * price;
        } else {
            return price;
        }
    }
}
