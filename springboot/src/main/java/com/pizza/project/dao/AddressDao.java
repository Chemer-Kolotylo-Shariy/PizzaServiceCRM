package com.pizza.project.dao;

import com.pizza.project.model.Address;
import com.pizza.project.model.ClientAddress;

import java.util.List;

public interface AddressDao extends CrudDao<Address> {
    List<Address> getAllAddresesByClientId(int id);
    List<Address> getAddressesByClientIdAndLableNotNull(Long id);
    Address get(String street, String house, int numb);
}
