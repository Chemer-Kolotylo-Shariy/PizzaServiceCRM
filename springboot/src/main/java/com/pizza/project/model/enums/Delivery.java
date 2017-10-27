package com.pizza.project.model.enums;

public enum Delivery {
    DELIVERY_MYSELF(1, "DELIVERY_MYSELF"),
    DELIVERY_COURIER(2, "DELIVERY_COURIER");

    private int id;
    private String name;

    Delivery(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
