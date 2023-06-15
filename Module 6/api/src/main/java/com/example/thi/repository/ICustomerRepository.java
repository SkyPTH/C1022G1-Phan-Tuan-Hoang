package com.example.thi.repository;

import com.example.thi.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
}
