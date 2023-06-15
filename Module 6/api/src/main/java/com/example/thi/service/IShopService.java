package com.example.thi.service;

import com.example.thi.model.Customer;
import com.example.thi.model.Shop;

import java.util.List;

public interface IShopService {
    Shop findByID(int id);
    List<Shop> shopList();
}
