package com.pizza.project.model.json;

import java.io.Serializable;
import java.util.List;

public class OrderJson implements Serializable{
    private Double price;
    private Integer payment;
    private Integer delivery;
    private String street;
    private String flat;
    private String house;
    private String phone;
    private String name;
    private List<ProductShortInfo> products;

    public OrderJson(Double price, Integer payment, Integer delivery, String street, String flat, String house, String phone, String name, List<ProductShortInfo> products) {
        this.price = price;
        this.payment = payment;
        this.delivery = delivery;
        this.street = street;
        this.flat = flat;
        this.house = house;
        this.phone = phone;
        this.name = name;
        this.products = products;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getPayment() {
        return payment;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public String getStreet() {
        return street;
    }

    public String getFlat() {
        return flat;
    }

    public Integer getHouse() {
        return Integer.parseInt(house);
    }

    public OrderJson() {
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public List<ProductShortInfo> getProducts() {
        return products;
    }

    public void setProducts(List<ProductShortInfo> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderJson{" +
                "price=" + price +
                ", payment=" + payment +
                ", delivery=" + delivery +
                ", street='" + street + '\'' +
                ", flat='" + flat + '\'' +
                ", house=" + house +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
