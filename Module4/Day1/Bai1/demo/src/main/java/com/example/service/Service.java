package com.example.service;

import com.example.repository.Repository;
import com.example.repository.IRepository;

public class Service implements  IService {
    IRepository iRepository=new Repository();
    @Override
    public Double changeMoney(Double n) {
        return iRepository.changeMoney(n);
    }
}
