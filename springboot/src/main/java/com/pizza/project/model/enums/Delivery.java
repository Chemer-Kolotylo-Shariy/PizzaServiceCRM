package com.pizza.project.model.enums;

public enum Delivery {
    DELIVERY_MYSELF(1, "DELIVERY_MYSELF"),
    DELIVERY_COURIER(2, "DELIVERY_COURIER");

    private int id;
    private String delivery;

    Delivery(int id, String delivery) {
        this.id = id;
        this.delivery = delivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
}
