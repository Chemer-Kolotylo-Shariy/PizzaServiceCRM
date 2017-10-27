package com.pizza.project.model;

import java.util.List;

public class Address {

    private Long id;
    private String street;
    private String house;
    private String apartament;
    private List<Client> clients;

    public Address() {
    }

    public Address(Long id, String street, String house, String apartament, List<Client> clients) {
        this.id = id;
        this.street = street;
        this.house = house;
        this.apartament = apartament;
        this.clients = clients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartament() {
        return apartament;
    }

    public void setApartament(String apartament) {
        this.apartament = apartament;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
