package com.example.service.impl;

import com.example.service.IMoneyService;

public class MoneyService implements IMoneyService {
    @Override
    public Double changeMoney(Double n) {
        return (n * 23000);
    }
}
