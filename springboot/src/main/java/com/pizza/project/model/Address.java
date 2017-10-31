package com.pizza.project.model;

import java.util.List;

public class Address {

    private Long id;
    private String street;
    private String house;
    private int apartament;
    private String lable;
    private List<Client> clients;

    public Address() {
    }

    public Address(Long id, String street, String house, int apartament, String lable) {
        this.id = id;
        this.street = street;
        this.house = house;
        this.apartament = apartament;
        this.lable = lable;
    }

    public Address(String street, String house, int apartament, String lable) {
        this.street = street;
        this.house = house;
        this.apartament = apartament;
        this.lable = lable;
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

    public int getApartament() {
        return apartament;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public void setApartament(int apartament) {
        this.apartament = apartament;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", apartament=" + apartament +
                ", lable='" + lable + '\'' +
                '}';
    }
}
