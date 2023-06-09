package com.example.thi.service.impl;

import com.example.thi.model.Customer;
import com.example.thi.model.Employee;
import com.example.thi.repository.IEmployeeRepository;
import com.example.thi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public Employee findByID(int id) {
        return iEmployeeRepository.findById(id).get();
    }
    public List<Employee> employeeList(){
        return (List<Employee>) iEmployeeRepository.findAll();
    }
}
