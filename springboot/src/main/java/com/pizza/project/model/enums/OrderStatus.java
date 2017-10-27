package com.pizza.project.model.enums;
/**
 * ADMIN_CONFIR - waiting for Administration confirmation
 * CHEF_CONFIR - waiting for Chef confirmation
 * COURIER_CONFIR - waiting for Curier confirmation
 * END - Client received an order
 * */
public enum OrderStatus {
    ADMIN_CONFIR(1, "ADMIN_CONFIR"),
    CHEF_CONFIR(2, "CHEF_CONFIR"),
    COURIER_CONFIR(3, "COURIER_CONFIR"),
    END(4, "END");

    private int id;
    private String name;

    OrderStatus(int id, String name) {
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
