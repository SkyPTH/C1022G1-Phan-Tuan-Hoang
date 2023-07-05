package com.example.riotshop_api.controller;

import com.example.riotshop_api.model.OrderCustomer;
import com.example.riotshop_api.service.IOrderCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/order")
public class OrderCustomerController {
    @Autowired
    private IOrderCustomer iOrderCustomer;
    @GetMapping("")
    public List<OrderCustomer> orderCustomerList(@RequestParam(defaultValue = "") String name){
        return iOrderCustomer.findAllByNameAccount(name);
    }
}
