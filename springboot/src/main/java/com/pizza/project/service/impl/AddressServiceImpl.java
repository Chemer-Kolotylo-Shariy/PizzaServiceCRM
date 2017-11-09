package com.pizza.project.service.impl;

import com.pizza.project.dao.AddressDao;
import com.pizza.project.model.Address;
import com.pizza.project.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public List<Address> getAddressesByClientLable(Long id) {
        return addressDao.getAddressesByClientIdAndLableNotNull(id);
    }

    @Override
    public Long createAddress(Address address) {
        return addressDao.create(address);
    }

    @Override
    public Address getAddress(Long id) {
        return addressDao.get(id);
    }
}
