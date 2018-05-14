package com.pizza.project.model;

import com.pizza.project.model.enums.Delivery;
import com.pizza.project.model.enums.OrderStatus;

public class Order {
    private Long id;
    private Double price;
    private OrderStatus orderStatus;
    private Payment payment;
    private Integer delivery;
    private Client client;
    private Address address;
    private String date;
    private String time;
    private String delivery_str;

    public Order() { }

    public Order(Long id) {
        this.id = id;
    }

    public Order(String date, String time, Double price, OrderStatus orderStatus, Payment payment, Integer delivery, Client client, Address address) {
        this.date = date;
        this.time = time;
        this.price = price;
        this.orderStatus = orderStatus;
        this.payment = payment;
        this.delivery = delivery;
        this.client = client;
        this.address = address;
    }

    public Order(Long id, String date, String time,
                 Double price, OrderStatus orderStatus,
                 Payment payment, Integer delivery,
                 Client client, Address address) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.price = price;
        this.orderStatus = orderStatus;
        this.payment = payment;
        this.delivery = delivery;
        this.client = client;
        this.address = address;
    }

    public String getDelivery_str() {
        return delivery_str;
    }

    public void setDelivery_str(String delivery_str) {
        this.delivery_str = delivery_str;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
