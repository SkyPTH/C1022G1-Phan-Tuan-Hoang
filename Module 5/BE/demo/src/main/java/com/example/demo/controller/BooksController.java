package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Clothings")
@CrossOrigin("*")
public class ClothingsController {
    @Autowired
    private IClothingsService iClothingsService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<Clothings> showListClothing(@RequestParam(required = false, defaultValue = "")String name,
                                    @RequestParam(required = false,defaultValue = "")String ClothingType,
                                    @PageableDefault(size = 3) Pageable pageable){
        Page<Clothings> ClothingsPage = iClothingsService.findByName(name,ClothingType,pageable);
        for (Clothings Clothing : ClothingsPage.getContent()) {
            SimpleDateFormat initialDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String importedDate = Clothing.getDate();
            String importedDateInNewFormat = "";
            try {
                Date date = initialDateFormat.parse(importedDate);
                importedDateInNewFormat = newDateFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Clothing.setDate(importedDateInNewFormat);
        }

        return ClothingsPage;


    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail")
    public Clothings detail(@RequestParam(required = false)Integer id){
        return iClothingsService.findByIdClothings(id);
    }
    @PostMapping("")
    public ResponseEntity<?> create(@Validated @RequestBody ClothingsDTO ClothingsDTO, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            iClothingsService.create(ClothingsDTO);
        }else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> err = bindingResult.getFieldErrors();
            for (FieldError error : err){
                if(!map.containsKey(error.getField())){
                    map.put(error.getField(),error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<?> edit(@Validated @RequestBody ClothingsDTO ClothingsDTO, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            iClothingsService.edit(ClothingsDTO);
        }else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> err = bindingResult.getFieldErrors();
            for (FieldError error : err){
                if(!map.containsKey(error.getField())){
                    map.put(error.getField(),error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam(required = false)Integer id){
        iClothingsService.deleteClothings(id);
    }
}
