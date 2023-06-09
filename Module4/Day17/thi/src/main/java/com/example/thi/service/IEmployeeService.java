package com.example.thi.service;

import com.example.thi.model.Customer;
import com.example.thi.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee findByID(int id);
    List<Employee> employeeList();
}
