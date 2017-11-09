package com.pizza.project.service;

import com.pizza.project.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddressesByClientLable(Long id);
    Long createAddress(Address address);
    Address getAddress(Long id);
}
