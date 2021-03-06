package com.pizza.project.dao;

import com.pizza.project.model.Client;

import java.util.List;

public interface ClientDao extends CrudDao<Client>{
    Client getByPhone(Long phone);
    List<Client> getAllClients();

}
