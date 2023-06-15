package com.example.thi.controller;

import com.example.thi.model.Customer;
import com.example.thi.model.Employee;
import com.example.thi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @GetMapping("/{idEmployee}")
    public ResponseEntity<Employee> findCustomerByID(@PathVariable("idEmployee") Integer idEmployee) {
        Employee employee = iEmployeeService.findByID(idEmployee);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<Employee>> findAll() {

        List<Employee> employeeList = iEmployeeService.employeeList();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
}
