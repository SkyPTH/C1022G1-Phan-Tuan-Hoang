package com.example.thi.service.impl;

import com.example.thi.model.Customer;
import com.example.thi.repository.ICustomerRepository;
import com.example.thi.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
@Autowired
    private ICustomerRepository iCustomerRepository;
    public Customer findByID(int id){
        return iCustomerRepository.findById(id).get();
    }
    public List<Customer> customerList(){
        return (List<Customer>) iCustomerRepository.findAll();
    }
}
