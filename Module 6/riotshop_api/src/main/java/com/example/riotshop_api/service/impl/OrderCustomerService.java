package com.example.riotshop_api.service.impl;

import com.example.riotshop_api.model.OrderCustomer;
import com.example.riotshop_api.repository.IOderCustomerRepository;
import com.example.riotshop_api.service.IOrderCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCustomerService implements IOrderCustomer {
    @Autowired
    private IOderCustomerRepository iOderCustomerRepository;

    @Override
    public OrderCustomer findByIdOderCustomer(int id) {
        return null;
    }

    @Override
    public List<OrderCustomer> findAllOderProduct() {
        return null;
    }

    @Override
    public List<OrderCustomer> findAllByNameAccount(String name) {
        return iOderCustomerRepository.findOrderCustomerByAccountUser_NameAccount(name);
    }

    @Override
    public Integer getTotalCodeAmount() {
        return null;
    }

    @Override
    public OrderCustomer createOderCustomer(OrderCustomer orderCustomer) {
        return iOderCustomerRepository.save(orderCustomer);
    }

}
