package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/food")
public class FoodController {
    @GetMapping("")
    public String save(@RequestParam(required = false) String[] condiment, Model model) {
        model.addAttribute("condiment", Arrays.toString(condiment));
        if (condiment == null) {
            model.addAttribute("condiment", "");
        }
        return "food";
    }

}
