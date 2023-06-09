package com.example.thi.service.impl;

import com.example.thi.model.Customer;
import com.example.thi.model.Shop;
import com.example.thi.repository.IShopRepository;
import com.example.thi.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService implements IShopService {
    @Autowired
    private IShopRepository iShopRepository;
    @Override
    public Shop findByID(int id) {
        return iShopRepository.findById(id).get();
    }
    public List<Shop> shopList(){
        return (List<Shop>) iShopRepository.findAll();
    }
}
