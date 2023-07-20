package com.example.riotshop_api.controller;

import com.example.riotshop_api.model.AccountUser;
import com.example.riotshop_api.service.IAccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/account")
public class AccountController {
    @Autowired
    IAccountUserService accountUserService;
    @GetMapping("/detail")
    public ResponseEntity<?> findAccountByUserName(@RequestParam String username) {
        return new ResponseEntity<>(accountUserService.findAccountUserByNameAccount(username), HttpStatus.OK);
    }
//    @GetMapping("/isAdmin")
//    public ResponseEntity<?> isAdmin(@RequestParam String username){
//        AccountUser accountUser=accountUserService.findAccountUserByNameAccount(username);
//
//    }
}
