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
    private String status;

    OrderStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
