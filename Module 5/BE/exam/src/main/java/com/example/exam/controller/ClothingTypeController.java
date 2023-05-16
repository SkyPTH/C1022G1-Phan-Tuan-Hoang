package com.example.exam.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothingType")
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
