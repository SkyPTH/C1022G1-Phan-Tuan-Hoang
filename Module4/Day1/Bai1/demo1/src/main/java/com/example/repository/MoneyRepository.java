package com.example.repository;

public class MoneyRepository implements IMoneyRepository {
    @Override
    public Double changeMoney(Double n) {
        Double m=n*23000;
        return m;
    }
}

