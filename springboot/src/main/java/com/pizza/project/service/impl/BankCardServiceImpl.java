package com.pizza.project.service.impl;

import com.pizza.project.dao.BankCardDao;
import com.pizza.project.model.BankCard;
import com.pizza.project.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankCardServiceImpl implements BankCardService {

    //private PasswordEncoder passwordEncoder;

    private BankCardDao bankCardDao;



//    @Autowired
//    public BankCardServiceImpl(PasswordEncoder passwordEncoder, BankCardDao bankCardDao) {
//        this.passwordEncoder = passwordEncoder;
//        this.bankCardDao = bankCardDao;
//    }



    @Autowired
    public BankCardServiceImpl(BankCardDao bankCardDao) {
        this.bankCardDao = bankCardDao;
    }

    @Override
    public Long create(BankCard bankCard) {
        return null;
    }

    @Override
    public List<BankCard> getByClientId(Long id) {
        return bankCardDao.getByClientId(id);
    }
}
