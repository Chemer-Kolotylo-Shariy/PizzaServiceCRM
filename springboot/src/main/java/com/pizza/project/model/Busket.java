package com.pizza.project.model;

import java.util.LinkedHashMap;

public class Busket {
    private Long idClient;
    private LinkedHashMap<Integer, Product> products;
    private Double price;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public LinkedHashMap<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(LinkedHashMap<Integer, Product> products) {
        this.products = products;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getBusketPrise() {
        for (int i = 0; i < products.size(); i++) {
            price += products.get(i).getPriceWithPersent();
        }
        return price;
    }
}
