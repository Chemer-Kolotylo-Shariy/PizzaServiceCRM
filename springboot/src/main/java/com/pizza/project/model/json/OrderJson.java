package com.pizza.project.model.json;

import java.io.Serializable;

public class OrderJson implements Serializable{
    private Double price;
    private Integer payment;
    private Integer delivery;
    private String street;
    private String flat;
    private String house;
    private String phone;
    private String name;

    public OrderJson() {
    }

    public OrderJson(Double price, Integer payment, Integer delivery, String street, String flat, String house, String phone, String name) {
        this.price = price;
        this.payment = payment;
        this.delivery = delivery;
        this.street = street;
        this.flat = flat;
        this.house = house;
        this.phone = phone;
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
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
