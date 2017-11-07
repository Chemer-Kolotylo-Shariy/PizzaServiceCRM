package com.pizza.project.model;

public class Payment {
    private Integer id;
    private String payment;

    public Payment() {
    }

    public Payment(String payment) {
        this.payment = payment;
    }

    public Payment(Integer id, String payment) {
        this.id = id;
        this.payment = payment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
