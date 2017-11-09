package com.pizza.project.service.impl;

import com.pizza.project.dao.ClientDao;
import com.pizza.project.model.Client;
import com.pizza.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

    //private PasswordEncoder passwordEncoder;
    private ClientDao clientDao;

//    @Autowired
//    public ClientServiceImpl(PasswordEncoder passwordEncoder, ClientDao clientDao) {
//        this.passwordEncoder = passwordEncoder;
//        this.clientDao = clientDao;
//    }

    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    @Transactional
    public Client getByPhone(Long phone) {
        return clientDao.getByPhone(phone);
    }

    @Override
    @Transactional
    public Long create(Client client) {
//        if (client.getPassword() != null){
//            client.setPassword(passwordEncoder.encode(client.getPassword()));
//        }
        return clientDao.create(client);
    }

    @Override
    public Long update(Client client) {
//        if (client.getPassword() != null){
//            client.setPassword(passwordEncoder.encode(client.getPassword()));
//        }
        return clientDao.update(client);
    }
}
