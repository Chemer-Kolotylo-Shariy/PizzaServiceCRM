package com.pizza.project.service;

import com.pizza.project.model.BankCard;

import java.util.List;

public interface BankCardService {
    Long create(BankCard bankCard);
    List<BankCard> getByClientId(Long id);
}
