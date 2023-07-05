package com.example.riotshop_api.service;

import com.example.riotshop_api.model.OrderCustomer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IOrderCustomer {
    OrderCustomer findByIdOderCustomer(int id);
    List<OrderCustomer> findAllOderProduct();
    List<OrderCustomer> findAllByNameAccount(String name);
    Integer getTotalCodeAmount();
    OrderCustomer createOderCustomer(OrderCustomer orderCustomer);


}
