package com.pizza.project.model;

public class ClientAddress {
    private Client client;
    private Address address;

    public ClientAddress() {
    }

    public ClientAddress(Client client, Address address) {
        this.client = client;
        this.address = address;
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
