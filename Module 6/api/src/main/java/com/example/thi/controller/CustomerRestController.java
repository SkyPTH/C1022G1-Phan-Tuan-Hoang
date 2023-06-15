package com.example.thi.controller;

import com.example.thi.model.Customer;
import com.example.thi.model.Product;
import com.example.thi.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerRestController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("/{idCustomer}")
    public ResponseEntity<Customer> findCustomerByID(@PathVariable("idCustomer") Integer idCustomer) {
        Customer customer = iCustomerService.findByID(idCustomer);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<Customer>> findAll() {

        List<Customer> customerList = iCustomerService.customerList();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
