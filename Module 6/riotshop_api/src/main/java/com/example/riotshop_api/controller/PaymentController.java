package com.example.riotshop_api.controller;

import com.example.riotshop_api.dto.RequestPayment;
import com.example.riotshop_api.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private ICartService iCartService;

    @PostMapping("/payment")
    public ResponseEntity<?> createPayment(@RequestBody RequestPayment requestPayment) throws UnsupportedEncodingException {
        return new ResponseEntity<>(iCartService.payment(requestPayment), HttpStatus.OK);

    }
}
