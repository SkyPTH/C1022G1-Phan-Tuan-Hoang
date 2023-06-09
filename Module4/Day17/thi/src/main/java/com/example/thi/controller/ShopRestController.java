package com.example.thi.controller;

import com.example.thi.model.Customer;
import com.example.thi.model.Employee;
import com.example.thi.model.Shop;
import com.example.thi.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/shop")
public class ShopRestController {
    @Autowired
    private IShopService iShopService;
    @GetMapping("/{idShop}")
    public ResponseEntity<Shop> findCustomerByID(@PathVariable("idShop") Integer idShop) {
        Shop shop = iShopService.findByID(idShop);
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<Shop>> findAll() {
        List<Shop> shopList = iShopService.shopList();
        if (shopList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }
}
