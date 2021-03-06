package com.pizza.project.service;

import com.pizza.project.model.Client;

public interface ClientService {
    Client getById(Long id);
    Client getByPhone(Long phone);
    Long create (Client client);
    Long update(Client client);
}
