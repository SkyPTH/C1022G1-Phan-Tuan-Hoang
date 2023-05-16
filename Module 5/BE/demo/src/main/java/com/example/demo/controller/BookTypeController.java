package com.example.demo.controller;

import com.example.exam.model.ClothingType;
import com.example.exam.service.IClothingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ClothingType")
@CrossOrigin("*")
public class ClothingTypeController {
    @Autowired
    private IClothingTypeService iClothingTypeService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<ClothingType> showClothingType(){
        return iClothingTypeService.findClothingType();
    }
}
