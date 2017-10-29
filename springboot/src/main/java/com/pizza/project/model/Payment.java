package com.pizza.project.model;

public class Payment {
    private int id;
    private String payment;

    public Payment(int id, String payment) {
        this.id = id;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
