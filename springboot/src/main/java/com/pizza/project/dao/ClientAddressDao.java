package com.pizza.project.dao;

import com.pizza.project.model.ClientAddress;

import java.util.List;

public interface ClientAddressDao extends CrudDao<ClientAddress> {
    List<ClientAddress> getAll();
}
