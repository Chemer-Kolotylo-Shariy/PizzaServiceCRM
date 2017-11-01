package com.pizza.project.dao;

import com.pizza.project.model.BankCard;

import java.util.List;

public interface BankCardDao extends CrudDao<BankCard> {
    List<BankCard> getByClientId(Long id);
    BankCard getByNumberAndDateAndSecredCode(Long id, int date, int secredCode);
    Long createWithClientId(BankCard bankCard);

}
