package com.pizza.project.dao;

import com.pizza.project.model.Address;

import java.util.List;

public interface AddressDao extends CrudDao<Address> {
    List<Address> getAllAddresesByClientId(int id);
}
