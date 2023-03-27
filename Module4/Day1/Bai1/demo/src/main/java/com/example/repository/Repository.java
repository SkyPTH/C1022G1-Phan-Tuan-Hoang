package com.example.repository;

public class Repository implements  IRepository{
    @Override
    public Double changeMoney(Double n) {
        Double m=n*23000;
        return m;
    }
}
