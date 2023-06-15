package com.example.thi.service;

import com.example.thi.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer findByID(int id);
    List<Customer> customerList();
}
