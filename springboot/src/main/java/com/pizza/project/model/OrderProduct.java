package com.pizza.project.model;

public class OrderProduct {

    private Order order;
    private Product product;
    private Integer countProduct;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, Integer amount) {
        this.order = order;
        this.product = product;
        this.countProduct = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(Integer countProduct) {
        this.countProduct = countProduct;
    }
}
