package com.example.thi.repository;

import com.example.thi.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
}
