package com.example.service;

import com.example.repository.IMoneyRepository;
import com.example.repository.MoneyRepository;

public class MoneyService implements IMoneyService {
    IMoneyRepository iMoneyRepository =new MoneyRepository();

    @Override
    public Double changeMoney(Double n) {
        return iMoneyRepository.changeMoney(n*23000);
    }
}
