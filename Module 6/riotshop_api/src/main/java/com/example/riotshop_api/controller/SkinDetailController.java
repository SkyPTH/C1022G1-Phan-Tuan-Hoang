package com.example.riotshop_api.controller;

import com.example.riotshop_api.service.ISkinDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/public/skin-detail")
public class SkinDetailController {
    @Autowired private ISkinDetailService iSkinDetailService;
    @GetMapping("")
    public ResponseEntity<?> skinDetail(@RequestParam int idProduct){
        return new ResponseEntity<>(iSkinDetailService.skinDetail(idProduct), HttpStatus.OK);
    }
}
