package com.pizza.project.model;




public class BankCard {

    private Long id;
    private Long number;
    private int date;
    private int secret_code;
    private Client client;

    public BankCard() {
    }

    public BankCard(Long id, Long number, int date, int secret_code, Client client) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.secret_code = secret_code;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getSecret_code() {
        return secret_code;
    }

    public void setSecret_code(int secret_code) {
        this.secret_code = secret_code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
